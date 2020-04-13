package com.javarush.task.task07.task0724;

/* 
Требования:
1. Программа не должна считывать данные с клавиатуры.
2. Добавить в класс Human поля: имя(String), пол(boolean), возраст(int), отец(Human), мать(Human).
3. Добавить в класс конструктор public Human(String name, boolean sex, int age).
4. Добавить в класс конструктор public Human(String name, boolean sex, int age, Human father, Human mother).
5. Создай 9 разных объектов типа Human (4 объекта без отца и матери и 5 объектов с ними)).
6. Выведи созданные объекты на экран.
Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Human> list = new ArrayList<>();
        Human grandfather1 = new Human("vsdvv", true,44);
        list.add(grandfather1);
        Human grandfather2 = new Human("vsdvv", true,44);
        list.add(grandfather2);
        Human grandmother1 = new Human("vsdvv", false,44);
        list.add(grandmother1);
        Human grandmother2 = new Human("vsdvv", false,44);
        list.add(grandmother2);
        Human father1 = new Human("vsdvv", true,42, grandfather1, grandmother1);
        list.add(father1);
        Human mother1 = new Human("vsdvv", false,42, grandfather2, grandmother2);
        list.add(mother1);
        Human child1 = new Human("vsdvv", true,42, father1, mother1);
        list.add(child1);
        Human child2 = new Human("vsdvv", false,42, father1, mother1);
        list.add(child2);
        Human child3 = new Human("vsdvv", true,42, father1, mother1);
        list.add(child3);
        for (Human s: list
             ) {
            System.out.println(s);

        }
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        Human father, mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}