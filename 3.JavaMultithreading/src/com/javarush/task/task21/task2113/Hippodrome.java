package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    public static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) {
        List<Horse> list = new ArrayList<>();
        list.add(new Horse("horse 1", 3, 0));
        list.add(new Horse("horse 2", 3, 0));
        list.add(new Horse("horse 3", 3, 0));
        game = new Hippodrome(list);
        game.run();
        game.printWinner();
    }

    public void run(){
        for(int i = 1; i <= 100; i ++){
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void move(){
        for (Horse horse: horses
             ) {horse.move();
        }
    }

    public void print(){
        for (Horse horse: horses
        ) {horse.print();
        }
        for (int i = 0; i < 10; i ++){
            System.out.println();
        }
    }
    public Horse getWinner(){
        double maxDistance = 0;
        Horse result = null;
        for (Horse horse: horses
             ) {
            if(horse.getDistance() > maxDistance){
                maxDistance = horse.getDistance();
                result = horse;
            }
        }
        return result;
    }
    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
