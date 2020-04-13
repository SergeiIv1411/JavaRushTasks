package com.javarush.task.task09.task0922;

/* 
Какое сегодня число?
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class Solution {

    public static void main(String[] args) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date = simpleDateFormat.
                parse(new BufferedReader(new InputStreamReader(System.in)).readLine());
        System.out.println(new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH).format(date).toUpperCase());
    }
}
