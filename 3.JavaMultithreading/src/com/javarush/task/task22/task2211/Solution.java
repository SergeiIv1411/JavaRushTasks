package com.javarush.task.task22.task2211;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Charset UTF = Charset.forName("UTF-8");
        Charset windows1251 = Charset.forName("Windows-1251");
        FileInputStream inputStream = new FileInputStream(args[0]);
        FileOutputStream outputStream = new FileOutputStream(args[1]);

        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        String string = new String(buffer, windows1251);
        byte[] newBuffer = string.getBytes(UTF);
        outputStream.write(newBuffer);
        inputStream.close();
        outputStream.close();
    }
}
