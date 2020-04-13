package com.javarush.task.task20.task2015;

import com.sun.corba.se.pept.encoding.OutputObject;

import java.io.*;

/*
Переопределение сериализации
*/
public class Solution implements Runnable, Serializable{
    private transient Thread runner;
    private int speed;

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        // do something here, does not matter
        try{
            System.out.println("start");
            Thread.sleep(speed);
            System.out.println("finish");
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     Переопределяем сериализацию.
     Для этого необходимо объявить методы:
     private void writeObject(ObjectOutputStream out) throws IOException
     private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        Thread thread  = new Thread(this);
        thread.start();
    }

    public static void main(String[] args) {
        File file = new File("E:\\Work\\fileIN.txt");
        try(
                OutputStream out = new FileOutputStream(file);
                ObjectOutput objectOutput = new ObjectOutputStream(out);
                InputStream in = new FileInputStream(file);
                ObjectInput objectInput = new ObjectInputStream(in);
        ){
            objectOutput.writeObject(new Solution(3000));
            Solution inst = (Solution) objectInput.readObject();
        }catch(IOException e){/*NOP*/
        }catch (ClassNotFoundException e){/*NOP*/}
    }
}

