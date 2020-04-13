package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Cat grandfater = new Cat(reader.readLine());
        Cat grandmother = new Cat(reader.readLine());

        Cat catFather = new Cat(reader.readLine());
        catFather.dad = grandfater;
        Cat catMother = new Cat(reader.readLine());
        catMother.mom = grandmother;

        Cat catSon = new Cat(reader.readLine(), catFather, catMother);
        Cat catDaughter = new Cat(reader.readLine(), catFather, catMother);

        System.out.println(grandfater);
        System.out.println(grandmother);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private Cat dad, mom;

        Cat(String name) {
            this.name = name;
        }

        public Cat(String name, Cat dad, Cat mom) {
            this.name = name;
            this.dad = dad;
            this.mom = mom;
        }


        @Override
        public String toString() {
            return "The cat's name is " + name + (mom != null ? ", mother is " + mom.name : ", no mother ") +
                        (dad != null ? ", father is " + dad.name : ", no father ");
        }
    }

}
