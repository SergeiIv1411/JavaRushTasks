package com.javarush.task.task08.task0827;

/* 
Работа с датой
*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) throws ParseException {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) throws ParseException {
        SimpleDateFormat start = new SimpleDateFormat("MMMM dd yyyy", Locale.ENGLISH);
        Date dateN = new Date();
        Date dateNew = new Date(date);

        dateN.setHours(0);
        dateN.setMinutes(0);
        dateN.setDate(1);
        dateN.setMonth(0);
        dateN.setSeconds(0);
        dateN.setYear(dateNew.getYear());


        long millisec = 60 * 60 * 24 * 1000;

        long time = dateNew.getTime() - dateN.getTime();

        return ((time / millisec) % 2 != 0);
    }
}
