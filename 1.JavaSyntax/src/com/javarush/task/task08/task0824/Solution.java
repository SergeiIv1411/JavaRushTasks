package com.javarush.task.task08.task0824;
import java.io.*;
import java.util.*;
import java.text.*;
/*
Собираем семейство
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код

        Human Rebenok1 = new Human ("Коля", true, 2);
        Human Rebenok2 = new Human ("Никита", true, 3);
        Human Rebenok3 = new Human ("Наташа", false, 12);

        ArrayList<Human> Deti = new ArrayList<Human>();
        Deti.add(Rebenok1);
        Deti.add(Rebenok2);
        Deti.add(Rebenok3);

        Human Father = new Human ("Семен", true, 44, Deti);
        Human Mother = new Human ("Люся", false, 39, Deti);

        ArrayList<Human> Roditeli1 = new ArrayList<Human>();
        Roditeli1.add(Father);
        ArrayList<Human> Roditeli2 = new ArrayList<Human>();
        Roditeli2.add(Mother);

        Human Ded1 = new Human ("Вася", true, 72, Roditeli1);
        Human Ded2 = new Human ("Петя", true, 74, Roditeli2);
        Human Babka1 = new Human ("Дуня", false, 64, Roditeli1);
        Human Babka2 = new Human ("Глаша", false, 67, Roditeli2);

        System.out.println(Ded1.toString());
        System.out.println(Ded2.toString());
        System.out.println(Babka1.toString());
        System.out.println(Babka2.toString());
        System.out.println(Father.toString());
        System.out.println(Mother.toString());
        System.out.println(Rebenok1.toString());
        System.out.println(Rebenok2.toString());
        System.out.println(Rebenok3.toString());
    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<Human>();

        Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }
        // **************второй конструктор***************
        Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
