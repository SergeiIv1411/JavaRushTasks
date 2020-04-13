package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        FileOutputStream outputStream1 = new FileOutputStream(reader.readLine());
        FileOutputStream outputStream2 = new FileOutputStream(reader.readLine());
        byte[] buffer = new byte[(inputStream.available() % 2 == 0 ? inputStream.available()/2 : inputStream.available()/2 + 1)];

            // прочитать очередной блок байт в переменную buffer и реальное количество в count
            int count = inputStream.read(buffer);
            outputStream1.write(buffer, 0, count); //записать блок(часть блока) во второй поток
            count = inputStream.read(buffer);
            outputStream2.write(buffer, 0, count); //записать блок(часть блока) во второй поток
            inputStream.close();
            outputStream1.close();
            outputStream2.close();
    }
}
