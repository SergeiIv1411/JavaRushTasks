package com.javarush.task.task15.task1522;

/* 
Закрепляем паттерн Singleton
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут
    static {
        readKeyFromConsoleAndInitPlanet();
    }
    public static void readKeyFromConsoleAndInitPlanet() {
        // implement step #5 here - реализуйте задание №5 тут
        try {
            String name = new BufferedReader(new InputStreamReader(System.in)).readLine();
            if(Planet.EARTH.equals(name)) thePlanet = Earth.getInstance();
            else if(Planet.MOON.equals(name)) thePlanet = Moon.getInstance();
            else if(Planet.SUN.equals(name)) thePlanet = Sun.getInstance();
            else thePlanet = null;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
