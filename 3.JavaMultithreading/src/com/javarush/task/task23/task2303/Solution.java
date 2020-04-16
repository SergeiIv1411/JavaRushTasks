package com.javarush.task.task23.task2303;

import jdk.nashorn.internal.ir.annotations.Immutable;

import java.lang.annotation.Annotation;

/*
Запрети создание экземпляров класса
*/
public class Solution {

    public static  class Listener implements Immutable {
        public void onMouseDown(int x, int y) {
            // Do something when the mouse down event occurs
        }

        public void onMouseUp(int x, int y) {
            // Do something when the mouse up event occurs
        }

        @Override
        public Class<? extends Annotation> annotationType() {
            return null;
        }
    }

    public static void main(String[] args) {

    }
}
