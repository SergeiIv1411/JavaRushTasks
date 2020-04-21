package com.javarush.games.minesweeper;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 10;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField, countFlags, score;
    private boolean isGameStopped = false;
    private int countClosedTiles = SIDE * SIDE;
    /*
    1. В классе MinesweeperGame должно существовать приватное статическое final поле String MINE, инициализированное при объявлении. Например, использовать можно UTF-16 символ мины "\uD83D\uDCA3".
    существовать приватное статическое final поле String FLAG, инициализированное при объявлении
     */
    private final static String MINE = "\\uD83D\\uDCA3".getBytes(Charset.forName("UTF-16")).toString();
    private final static String FLAG = "\\uD83D\\uDEA9".getBytes(Charset.forName("UTF-16")).toString();
    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    private void createGame() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                boolean isMine = getRandomNumber(10) < 1;
                if (isMine) {
                    countMinesOnField++;
                }
                gameField[y][x] = new GameObject(x, y, isMine);
                setCellColor(x, y, Color.ORANGE);
                setCellValue(x, y, "");
            }
        }
        countFlags = countMinesOnField;
        countMineNeighbors();
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        if (isGameStopped) {
            restart();
        }
        else {
        super.onMouseLeftClick(x, y);
        openTile(x, y);
        }
    }

    private List<GameObject> getNeighbors(GameObject gameObject) {
        List<GameObject> result = new ArrayList<>();
        for (int y = gameObject.y - 1; y <= gameObject.y + 1; y++) {
            for (int x = gameObject.x - 1; x <= gameObject.x + 1; x++) {
                if (y < 0 || y >= SIDE) {
                    continue;
                }
                if (x < 0 || x >= SIDE) {
                    continue;
                }
                if (gameField[y][x] == gameObject) {
                    continue;
                }
                result.add(gameField[y][x]);
            }
        }
        return result;
    }

    private void openTile(int x, int y){
        if (gameField[y][x].isOpen || gameField[y][x].isFlag || isGameStopped){
            return;
        }
        if (gameField[y][x].isMine){
            setCellValueEx(x, y, Color.RED, MINE);
            isGameStopped = true;
            gameOver();
        } else{
            setCellNumber(x, y, gameField[y][x].countMineNeighbors);
            setCellColor(x, y, Color.GREEN);
            countClosedTiles --;
            score += 5;
            setScore(score);
            if (countClosedTiles == countMinesOnField) win();
        }
        gameField[y][x].isOpen = true;

        if (!gameField[y][x].isMine && gameField[y][x].countMineNeighbors == 0){
            setCellValue(x, y, "");
            List<GameObject> neighbors = getNeighbors(gameField[y][x]);
            for (GameObject neighbor: neighbors
                 ) {
                    if (!neighbor.isOpen) {
                        openTile(neighbor.x, neighbor.y);
                    }
            }
        }
    }

    @Override
    public void onMouseRightClick(int x, int y) {
        super.onMouseRightClick(x, y);
        markTile(x, y);
    }

    private void markTile(int x, int y){
        if (gameField[y][x].isOpen || (countFlags == 0 && !gameField[y][x].isFlag) || isGameStopped){
            return;
        }
        gameField[y][x].isFlag = !gameField[y][x].isFlag;
        if (gameField[y][x].isFlag) {
            countFlags --;
            setCellValue(x, y, FLAG);
            setCellColor(x, y, Color.YELLOW);
        } else {
            countFlags ++;
            setCellValue(x, y, "");
            setCellColor(x, y, Color.ORANGE);
        }

    }

    private void countMineNeighbors() {
        List<GameObject> list = new ArrayList<>();
        for (int x = 0; x < SIDE; x++) {
            for (int y = 0; y < SIDE; y++) {
                if (!gameField[y][x].isMine) {
                    list = getNeighbors(gameField[y][x]);
                    for (GameObject object : list) {
                        if (object.isMine) {
                            gameField[y][x].countMineNeighbors++;
                        }
                    }
                }
            }
        }
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.AQUAMARINE, "Game over", Color.RED, 20);
    }

    private  void win() {
        isGameStopped = true;
        showMessageDialog(Color.AQUAMARINE, "You are winner!!!", Color.GOLD, 40);
    }

    private void restart() {
        isGameStopped = false;
        countClosedTiles = SIDE * SIDE;
        score = 0;
        setScore(score);
        countMinesOnField =0;
        createGame();
    }
}