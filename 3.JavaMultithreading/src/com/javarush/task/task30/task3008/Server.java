package com.javarush.task.task30.task3008;

import java.util.Map;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.util.concurrent.ConcurrentHashMap;

import static com.javarush.task.task30.task3008.ConsoleHelper.readInt;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();
    public static void sendBroadcastMessage(Message message)
    {
        try
        {
            for (Connection connection : connectionMap.values())
            {
                connection.send(message);
            }

        }catch(IOException e){System.out.println("Не смогли отправить сообщение.");}
    }
    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
//            super.run();
            ConsoleHelper.writeMessage("Connection established with address: " + socket.getRemoteSocketAddress());
            String userName = null;

            try (Connection connection = new Connection(socket)){
                //Вызывать метод, реализующий рукопожатие с клиентом, сохраняя имя нового клиента.
                userName = serverHandshake(connection);

                // Рассылать всем участникам чата информацию об имени присоединившегося участника
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));

                // Сообщать новому участнику о существующих участниках.
                notifyUsers(connection, userName);

                //Запускать главный цикл обработки сообщений сервером
                serverMainLoop(connection, userName);

            } catch (ClassNotFoundException | IOException e) {
                ConsoleHelper.writeMessage("В Handler произошла ошибка при обмене данными с удаленным адресом");
//                e.printStackTrace();
            } finally {

                //После того как все исключения обработаны, если п.11.3 отработал и возвратил нам имя,
                //мы должны удалить запись для этого имени из connectionMap и разослать всем остальным участникам сообщение
                //с типом USER_REMOVED и сохраненным именем.
                if (userName != null) {
                    connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                    // ConsoleHelper.writeMessage("Соединение с удаленным адресом закрыто");
                }

            }
            ConsoleHelper.writeMessage("Соединение с удаленным адресом закрыто");
        }
        private String serverHandshake(Connection connection)throws IOException, ClassNotFoundException
        {
            String userName;
            Message request = new Message(MessageType.NAME_REQUEST);
            Message answer;
            do
            {
                connection.send(request);
                answer = connection.receive();
                userName = answer.getData();

            }while((answer.getType() != MessageType.USER_NAME)|| userName.isEmpty() || connectionMap.containsKey(userName));
            connectionMap.put(userName, connection);
            connection.send(new Message(MessageType.NAME_ACCEPTED, "Ваше имя принято!"));
            return userName;
        }
        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> entry: connectionMap.entrySet()) {
                if (!entry.getKey().equals(userName)){
                    connection.send(new Message(MessageType.USER_ADDED, entry.getKey()));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
           while (true) {
               Message answer = connection.receive();
               if (answer.getType() == MessageType.TEXT) {
                   sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + answer.getData()));
               } else {
                   ConsoleHelper.writeMessage("Error. Type of input message must be TEXT");
               }
           }
        }
    }

    public static void main(String[] args)throws Exception {
        Handler handler;
        ServerSocket serverSocket = null;
        Socket socket;
        int port = readInt();
        try {
            serverSocket = new ServerSocket(port); //
            System.out.println("Сервер запущен!");
            while(true) {
                socket = serverSocket.accept();
                handler = new Handler(socket);
                handler.start();
            }
        }
        catch (Exception e) {
            e.printStackTrace();}
        finally{
            serverSocket.close();}

    }
}
