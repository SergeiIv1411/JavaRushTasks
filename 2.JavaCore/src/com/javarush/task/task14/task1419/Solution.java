package com.javarush.task.task14.task1419;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            int i = 1-2-3;
            int[] a = new int[i];

        } catch (Exception e) {
            exceptions.add(e);
        }


        try {
            int[] i = new int[1];
            for(int i1 = 0;i1<5;i1++){
                i[i1]= 4;
            }

        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            FileInputStream f = new FileInputStream("BEKA");
            f.read();

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            ArrayList<String> os = new ArrayList<>();
            Object o = new Object();
            os.add(String.valueOf(o));

        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            Object o = null;
            o.equals("lela");

        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            String s = "ira23";
            Integer.parseInt(s);

        } catch (Exception e) {
            exceptions.add(e);
        }
        Object szStr[] = new String[10];

        try
        {
            szStr[0] = new Character('*');
        }catch (Exception e) {
            exceptions.add(e);
        }
        Object ch = new Character('*');

        try
        {
            System.out.println((Byte)ch);
        }catch (Exception e) {
            exceptions.add(e);
        }
        String szShortString = "123";

        try
        {
            char chr = szShortString.charAt(10);
        }catch (Exception e) {
            exceptions.add(e);
        }
        try
        {
            int num = -3;
            if (num < 0) throw new IllegalArgumentException();
        }catch (Exception e) {
            exceptions.add(e);
        }

    }
}
