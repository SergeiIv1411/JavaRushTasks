package com.javarush.task.task05.task0517;

/* 
10. У класса должен быть конструктор, принимающий в качестве параметров вес, цвет, адрес и инициализирующий все переменные класса, кроме имени.
*/

public class Cat {
    String name, address, color;
    int age, weight;

    public Cat(String name) {
        this.name = name;
        this.address = null;
        this.color = "black";
        this.age = 3;
        this.weight = 6;
    }

    public Cat(String name, int weight, int age) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.address = null;
        this.color = "black";
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        this.address = null;
        this.color = "black";
        this.weight = 6;
    }

    public Cat(int weight, String color) {
        this.name = null;
        this.age = 2;
        this.address = null;
        this.color = color;
        this.weight = weight;
    }

    public Cat(int weight, String color, String address) {
        this.address = address;
        this.color = color;
        this.weight = weight;
        this.name = null;
        this.age = 2;
    }

    public static void main(String[] args) {

    }
}
