package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        FileOutputStream outputStream = new FileOutputStream(reader.readLine());
        byte[] data = new byte[inputStream.available()];
        byte[] dataOut = new byte[inputStream.available()];
        inputStream.read(data);
        int j = data.length-1;
        for(int i = data.length - 1; i >= 0; i --){
            dataOut[j-i] = data[i];
        }
        outputStream.write(dataOut);
        inputStream.close();
        outputStream.close();
    }
}
