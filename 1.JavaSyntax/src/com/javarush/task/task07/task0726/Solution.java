package com.javarush.task.task07.task0726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Не компилируется задача про котиков
*/

public class Solution {
    public final static ArrayList<Cat> CATS = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        String str;
        String name = "";
        boolean istrue = true;
        int age=0,weight=0,tailLength=0;
        while (istrue) {
            str = reader.readLine();
            switch (count) {
                case 0: {
                    name = str;
                    if (name == null || name.isEmpty()) {
                        istrue = false;
                    }
                    break;
                }
                case 1: {age = Integer.parseInt(str);break;}
                case 2: {weight = Integer.parseInt(str);break;}
                case 3: {tailLength = Integer.parseInt(str);break;}
            }
            if (istrue && count == 3){
            Cat cat = new Cat(name, age, weight, tailLength);
            CATS.add(cat);
            count = 0;continue;}
            count++;
        }

        printList();
    }

    public static void printList() {
        for (int i = 0; i < CATS.size(); i++) {
            System.out.println(CATS.get(i));
        }
    }

    public static class Cat {
        private String name;
        private int age;
        private int weight;
        private int tailLength;

        Cat(String name, int age, int weight, int tailLength) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.tailLength = tailLength;
        }

        @Override
        public String toString() {
            return "Cat's name: " + name + ", age: " + age + ", weight: " + weight + ", tail: " + tailLength;
        }
    }
}