package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {
    public static void main(String[] args) {
        Man man1 = new Man("sfdc", 23,"sdvdvsdv");
        Man man2 = new Man("sfdc", 23,"sdvdvsdv");;

        Woman woman1 = new Woman("sfdc", 23,"sdvdvsdv");;
        Woman woman2 = new Woman("sfdc", 23,"sdvdvsdv");;

        System.out.println(man1);
        System.out.println(man2);

        System.out.println(woman1);
        System.out.println(woman2);
    }

    public static class Man {
        String name, address;
        int age;

        public Man(String name) {
            this.name = name;
        }

        public Man(String name, String address) {
            this.name = name;
            this.address = address;
        }

        public Man(String name, int age, String address) {
            this.name = name;
            this.address = address;
            this.age = age;
        }

        @Override
        public String toString() {
            return name + " " + age + " " + address;
        }
    }

    public static class Woman {
        String name, address;
        int age;

        public Woman(String name) {
            this.name = name;
        }

        public Woman(String name, String address) {
            this.name = name;
            this.address = address;
        }

        public Woman(String name, int age, String address) {
            this.name = name;
            this.address = address;
            this.age = age;
        }
        @Override
        public String toString() {
            return name + " " + age + " " + address;
        }
    }
}
