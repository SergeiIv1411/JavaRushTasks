package com.javarush.games.snake;

import com.javarush.engine.cell.*;

public class SnakeGame extends Game {
    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;
    private Snake snake;
    private Apple apple;
    private int turnDelay;
    private int score;
    private boolean isGameStopped;
    private static final int GOAL = 28;

    @Override
    public void initialize() {
        super.initialize();
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    @Override
    public void onTurn(int step) {
        snake.move(apple);
        if (!apple.isAlive) {
            createNewApple();
            score += 5;
            setScore(score);
            turnDelay -= 10;
            setTurnTimer(turnDelay);
        }
        if (!snake.isAlive){
            gameOver();
        }
        if (snake.getLength() > GOAL){
            win();
        }
        drawScene();
    }

    @Override
    public void onKeyPress(Key key) {
        switch (key) {
            case DOWN:
                snake.setDirection(Direction.DOWN);
                break;
            case UP:
                snake.setDirection(Direction.UP);
                break;
            case RIGHT:
                snake.setDirection(Direction.RIGHT);
                break;
            case LEFT:
                snake.setDirection(Direction.LEFT);
                break;
            case SPACE:
                if (isGameStopped)
                    createGame();
        }

    }

    private void drawScene(){
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                setCellValueEx(x, y, Color.DARKSEAGREEN, "");
            }
        }
        snake.draw(this);
        apple.draw(this);

    }

    private void createGame(){
        snake = new Snake(WIDTH / 2, HEIGHT / 2);
        createNewApple();
        isGameStopped = false;
        drawScene();
        turnDelay = 300;
        setTurnTimer(turnDelay);
        score = 0;
        setScore(score);
    }

    private void createNewApple() {
        boolean breakPoint = true;
        while (breakPoint) {
            Apple newApple = new Apple(getRandomNumber(WIDTH), getRandomNumber(HEIGHT));
            if (!snake.checkCollision(newApple)){
                breakPoint = false;
                apple = newApple;
            }
        }
    }

    private void gameOver() {
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.RED, " Loshara lose", Color.BLACK, 50);
    }

    private void win() {
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.BLUE, " You are win!!!", Color.GOLD, 50);
    }
}
