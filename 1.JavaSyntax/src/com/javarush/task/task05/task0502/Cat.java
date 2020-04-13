package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
       /* int counththis = 0, countanother = 0;
        if (age > anotherCat.age) counththis += 3; else
            if (age < anotherCat.age) countanother += 3;
        if (weight > anotherCat.weight) counththis += 2;
        else
        if (weight < anotherCat.weight) countanother += 2;
        if (strength > anotherCat.strength) counththis += 1;
        else
        if (strength < anotherCat.strength) countanother += 1;
        if (counththis > countanother) return true;
        else return false;*/
        int i=0; int k=0;
        if (this.age>anotherCat.age) {  i++;  }
        else if (this.age==anotherCat.age) {i ++; k ++;}
        else {k++;}
        if (this.weight>anotherCat.weight) { i++; }
        else if (this.weight==anotherCat.weight) {i ++; k ++;}
        else {k++;}
        if (this.strength>anotherCat.strength) { i++; }
        else if (this.strength==anotherCat.strength) {i ++; k ++;}
        else {k++;}
        if (i>k) {return true;}
        else if (i==k) {return false;}
        else return false;
    }

    public static void main(String[] args) {

    }
}
