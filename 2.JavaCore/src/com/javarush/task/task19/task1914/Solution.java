package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream currentStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        testString.printSomething();
        System.setOut(currentStream);
        String result = outputStream.toString();
        String[] mas = result.split(" ");
        int resultCount = 0;
        switch (mas[1]){
            case "+":{
                resultCount = Integer.parseInt(mas[0]) + Integer.parseInt(mas[2]);
                break;
            }
            case "-":{
                resultCount = Integer.parseInt(mas[0]) - Integer.parseInt(mas[2]);
                break;
            }
            case "*":{
                resultCount = Integer.parseInt(mas[0]) * Integer.parseInt(mas[2]);
                break;
            }
        }
        System.out.print(mas[0] + " " + mas[1] + " " + mas[2] + " = " + resultCount);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

