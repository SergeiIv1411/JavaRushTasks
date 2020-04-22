package com.javarush.games.racer;

import com.javarush.engine.cell.*;
import com.javarush.games.racer.road.RoadManager;

public class RacerGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    public static final int CENTER_X = WIDTH / 2;
    public static final int ROADSIDE_WIDTH = 14;

    private static final int RACE_GOAL_CARS_COUNT = 40;

    private RoadMarking roadMarking;
    private PlayerCar player;
    private RoadManager roadManager;
    private FinishLine finishLine;
    private ProgressBar progressBar;

    private boolean isGameStopped;

    private int score;

    @Override
    public void initialize() {
        showGrid(false);
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    @Override
    public void setCellColor(int x, int y, Color color) {
        if(x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT) {
            super.setCellColor(x, y, color);
        }
    }

    @Override
    public void onTurn(int step) {
        score -= 5;
        setScore(score);
        if (roadManager.checkCrush(player)) {
            gameOver();
            drawScene();
        } else
            if (finishLine.isCrossed(player)) {
                win();
                drawScene();
            } else
            if (roadManager.getPassedCarsCount() >= RACE_GOAL_CARS_COUNT) {
                finishLine.show();
            } else
        {
            roadManager.generateNewRoadObjects(this);
            moveAll();
            drawScene();
        }

    }

    @Override
    public void onKeyPress(Key key) {
        if (key == Key.RIGHT) {
                player.setDirection(Direction.RIGHT);
            } else
                if (key == Key.LEFT) {
                player.setDirection(Direction.LEFT);
            } else
                if (key == Key.SPACE && isGameStopped) {
                    createGame();
                } else
                    if (key == Key.UP) {
                        player.speed = 2;
                    }
    }

    @Override
    public void onKeyReleased(Key key) {
        if ((key == Key.RIGHT && player.getDirection() == Direction.RIGHT) ||
                (key == Key.LEFT && player.getDirection() == Direction.LEFT)) {
            player.setDirection(Direction.NONE);
        } else
            if (key == Key.UP) {
                player.speed = 1;
            }
    }

    private void createGame(){
        roadMarking = new RoadMarking();
        player = new PlayerCar();
        roadManager = new RoadManager();
        finishLine = new FinishLine();
        progressBar = new ProgressBar(RACE_GOAL_CARS_COUNT);
        isGameStopped = false;

        score = 3500;

        drawScene();
        setTurnTimer(40);

    }

    private void drawScene(){
        drawField();
        roadMarking.draw(this);
        player.draw(this);
        roadManager.draw(this);
        finishLine.draw(this);
        progressBar.draw(this);
    }

    private void drawField(){
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x ++) {
                if (x >= ROADSIDE_WIDTH && x < WIDTH - ROADSIDE_WIDTH && x != CENTER_X) {
                    setCellColor(x, y, Color.DIMGREY);
                } else if (x == CENTER_X){
                    setCellColor(x, y, Color.WHITE);
                } else {
                    setCellColor(x, y, Color.GREEN);
                }
            }
        }
    }

    private void moveAll(){
        roadMarking.move(player.speed);
        player.move();
        roadManager.move(player.speed);
        finishLine.move(player.speed);
        progressBar.move(roadManager.getPassedCarsCount());
    }

   private void gameOver(){
       isGameStopped = true;
       showMessageDialog(Color.RED, "You lose", Color.BLACK, 50);
       stopTurnTimer();
       player.stop();
   }

   private void win() {
       isGameStopped = true;
       showMessageDialog(Color.BLUE, "You WIN!!!", Color.GOLD, 50);
       stopTurnTimer();
    }

}
