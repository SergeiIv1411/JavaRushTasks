package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException, ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy", Locale.ENGLISH);
        switch (args[0]){
            case "-c": {

                allPeople.add(args[2].equals("м") ? Person.createMale(args[1],simpleDateFormat.parse(args[3])) : Person.createFemale(args[1],simpleDateFormat.parse(args[3])));
                System.out.println(allPeople.size()-1);
                break;
            }
            case "-u": {
                if(Integer.parseInt(args[1]) >= allPeople.size()){
                    System.out.println("введеный id больше допустимого");
                    return;
                }
                allPeople.add(Integer.parseInt(args[1]), args[3].equals("м") ? Person.createMale(args[2],simpleDateFormat.parse(args[4])) : Person.createFemale(args[2],simpleDateFormat.parse(args[4])));
                break;
            }
            case "-d": {
                if(Integer.parseInt(args[1]) >= allPeople.size()){
                    System.out.println("введеный id больше допустимого");
                    return;
                }
                allPeople.add(Integer.parseInt(args[1]), null);
                break;
            }
            case "-i": {
                if(Integer.parseInt(args[1]) >= allPeople.size()){
                    System.out.println("введеный id больше допустимого");
                    return;
                }
                Person person = allPeople.get(Integer.parseInt(args[1]));
                //Миронов м 15-Apr-1990
                System.out.println(person.getName() + " " + ((person.getSex() == Sex.MALE) ? "м": "ж") + " " + new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(person.getBirthDate()));
                break;
            }
        }
    }
}
