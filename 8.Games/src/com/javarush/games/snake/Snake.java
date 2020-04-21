package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";
    public boolean isAlive = true;
    private Direction direction = Direction.LEFT;

    private List<GameObject> snakeParts = new ArrayList<>();


    public Snake(int x, int y) {
        snakeParts.add(new GameObject(x,y));
        snakeParts.add(new GameObject(x + 1,y));
        snakeParts.add(new GameObject(x + 2,y));

    }

    public void setDirection(Direction direction) {
        if (!(((this.direction == Direction.LEFT || this.direction == Direction.RIGHT) &&
                (snakeParts.get(0).x == snakeParts.get(1).x)) ||
                ((this.direction == Direction.UP || this.direction == Direction.DOWN) &&
                        (snakeParts.get(0).y == snakeParts.get(1).y))))
            this.direction = direction;
        /*if (direction == Direction.LEFT && this.direction == Direction.RIGHT){
            return;
        }
        if (direction == Direction.UP && this.direction == Direction.DOWN){
            return;
        }
        if (direction == Direction.RIGHT && this.direction == Direction.LEFT){
            return;
        }
        if (direction == Direction.DOWN && this.direction == Direction.UP){
            return;
        }

        this.direction = direction;
         */
    }

    public void draw(Game game){

        for (int i = 0; i < snakeParts.size(); i ++) {
            if (i == 0) {
                game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y, Color.NONE
                        , HEAD_SIGN, isAlive ? Color.BLACK : Color.RED, 75);
            } else {
                game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y, Color.NONE
                        , BODY_SIGN, isAlive ? Color.BLACK : Color.RED, 75);
            }
        }

    }

    public void move(Apple apple) {
        GameObject newHead = createNewHead();
        if (newHead.x >= SnakeGame.WIDTH || newHead.x < 0 || newHead.y >= SnakeGame.HEIGHT || newHead.y < 0 || checkCollision(newHead)) {
            isAlive = false;
        } else
        if (newHead.x == apple.x && newHead.y == apple.y) {
                snakeParts.add(0, newHead);
                apple.isAlive = false;
            }
        else {
            snakeParts.add(0, newHead);
            removeTail();
        }
    }

    public GameObject createNewHead() {
        GameObject newHead = null;
        switch (direction) {
            case UP: {
                newHead = new GameObject(snakeParts.get(0).x, snakeParts.get(0).y - 1);
                break;
            }
            case DOWN: {
                newHead = new GameObject(snakeParts.get(0).x, snakeParts.get(0).y + 1);
                break;
            }
            case LEFT: {
                newHead = new GameObject(snakeParts.get(0).x - 1, snakeParts.get(0).y);
                break;
            }
            case RIGHT: {
                newHead = new GameObject(snakeParts.get(0).x + 1, snakeParts.get(0).y);
                break;
            }
        }
        return newHead;
    }

    public void removeTail() {
        snakeParts.remove(snakeParts.size() - 1);
    }

    public boolean checkCollision(GameObject newHead) {
        boolean isCollision = false;
        for (GameObject snakePart : snakeParts) {
           if(newHead.x == snakePart.x && newHead.y == snakePart.y){
               isCollision = true;
               break;
           }
        }
        return isCollision;
    }

    public int getLength() {
        return snakeParts.size();
    }
}
