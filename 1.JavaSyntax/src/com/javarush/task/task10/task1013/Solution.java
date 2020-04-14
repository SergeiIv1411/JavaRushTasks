package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private String name;
        private int age;
        private Human parentDad;
        private Human parentMom;
        private String adress;
        private int weignt;

        public Human(String name) {
            this.name = name;
        }

        public Human(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Human(String name, int age, Human parentDad) {
            this.name = name;
            this.age = age;
            this.parentDad = parentDad;
        }

        public Human(String name, int age, Human parentDad, Human parentMom) {
            this.name = name;
            this.age = age;
            this.parentDad = parentDad;
            this.parentMom = parentMom;
        }

        public Human(String name, int age, Human parentDad, Human parentMom, String adress) {
            this.name = name;
            this.age = age;
            this.parentDad = parentDad;
            this.parentMom = parentMom;
            this.adress = adress;
        }

        public Human(String name, int age, Human parentDad, Human parentMom, String adress, int weignt) {
            this.name = name;
            this.age = age;
            this.parentDad = parentDad;
            this.parentMom = parentMom;
            this.adress = adress;
            this.weignt = weignt;
        }

        public Human(int age, Human parentDad, Human parentMom) {
            this.age = age;
            this.parentDad = parentDad;
            this.parentMom = parentMom;
        }

        public Human(Human parentDad, Human parentMom) {
            this.parentDad = parentDad;
            this.parentMom = parentMom;
        }

        public Human(String name, Human parentDad, Human parentMom) {
            this.name = name;
            this.parentDad = parentDad;
            this.parentMom = parentMom;
        }

        public Human(String name, Human parentDad, Human parentMom, String adress) {
            this.name = name;
            this.parentDad = parentDad;
            this.parentMom = parentMom;
            this.adress = adress;
        }
    }
}
