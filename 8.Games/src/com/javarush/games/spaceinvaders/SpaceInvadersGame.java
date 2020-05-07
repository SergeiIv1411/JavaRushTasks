package com.javarush.games.spaceinvaders;

import com.javarush.engine.cell.*;
import com.javarush.games.spaceinvaders.gameobjects.Bullet;
import com.javarush.games.spaceinvaders.gameobjects.EnemyFleet;
import com.javarush.games.spaceinvaders.gameobjects.PlayerShip;
import com.javarush.games.spaceinvaders.gameobjects.Star;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SpaceInvadersGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    public static final int COMPLEXITY = 5;

    private static final int PLAYER_BULLETS_MAX = 1;

    private List<Star> stars;
    private List<Bullet> enemyBullets;
    private List<Bullet> playerBullets;

    private EnemyFleet enemyFleet;
    private PlayerShip playerShip;

    private boolean isGameStopped;
    private int animationsCount;
    private int score;

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    @Override
    public void onTurn(int step) {
        moveSpaceObjects();
        check();
        Bullet bullet = enemyFleet.fire(this);
        if (bullet != null) {
            enemyBullets.add(bullet);
        }
        setScore(score);
        drawScene();
    }

    @Override
    public void onKeyPress(Key key) {
        if (isGameStopped && key == Key.SPACE) {
            createGame();
            return;
        }
        if (key == Key.LEFT) {
            playerShip.setDirection(Direction.LEFT);
        } else
            if (key == Key.RIGHT) {
                playerShip.setDirection(Direction.RIGHT);
            } else if (key == Key.SPACE) {
                Bullet playerBullet = playerShip.fire();
                if (playerBullet != null && playerBullets.size() < PLAYER_BULLETS_MAX) {
                    playerBullets.add(playerBullet);
                }
            }
    }

    @Override
    public void onKeyReleased(Key key) {
        if ((key == Key.LEFT && playerShip.getDirection() == Direction.LEFT) ||
                (key == Key.RIGHT && playerShip.getDirection() == Direction.RIGHT)) {
            playerShip.setDirection(Direction.UP);
        }
    }

    @Override
    public void setCellValueEx(int x, int y, Color cellColor, String value) {
        if (x < 0 || x >= WIDTH || y < 0 || y >= HEIGHT) {
            return;
        }
        super.setCellValueEx(x, y, cellColor, value);
    }

    private void createGame() {
        createStars();
        enemyFleet = new EnemyFleet();
        enemyBullets = new ArrayList<Bullet>();
        playerBullets = new ArrayList<Bullet>();
        playerShip = new PlayerShip();
        isGameStopped = false;
        animationsCount = 0;
        score = 0;
        drawScene();
        setTurnTimer(40);
    }

    private void drawScene() {
        drawField();
        enemyFleet.draw(this);
        for (Bullet bullet : enemyBullets) {
            bullet.draw(this);
        }
        for (Bullet bullet : playerBullets) {
            bullet.draw(this);
        }

        playerShip.draw(this);
    }

    private void drawField() {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                setCellValueEx(x, y, Color.BLACK, "");
            }
        }
        for (Star star:stars) {
            star.draw(this);
        }

    }

    private void createStars() {
        stars = new ArrayList<Star>();
        while (stars.size() < 8){
            stars.add(new Star(getRandomNumber(HEIGHT - 1), getRandomNumber(WIDTH - 1)));
        }
    }

    private void moveSpaceObjects() {
        enemyFleet.move();
        for (Bullet bullet : enemyBullets) {
            bullet.move();
        }
        for (Bullet bullet : playerBullets) {
            bullet.move();
        }

        playerShip.move();
    }

    private void removeDeadBullets() {
        Iterator<Bullet> bulletIterator = enemyBullets.iterator();
        while(bulletIterator.hasNext()) {

            Bullet nextBullet = bulletIterator.next();
            if(!nextBullet.isAlive || nextBullet.y >= HEIGHT - 1) {
                bulletIterator.remove();
            }
        }

        Iterator<Bullet> playerBulletIterator = playerBullets.iterator();
        while(playerBulletIterator.hasNext()) {

            Bullet nextPlayerBullet = playerBulletIterator.next();
            if(!nextPlayerBullet.isAlive || nextPlayerBullet.y + nextPlayerBullet.height < 0) {
                playerBulletIterator.remove();
            }
        }

    }

    private void check() {
        playerShip.verifyHit(enemyBullets);
        score += enemyFleet.verifyHit(playerBullets);
        enemyFleet.deleteHiddenShips();
        removeDeadBullets();
        if (!playerShip.isAlive) {
            stopGameWithDelay();
        }

        if (enemyFleet.getBottomBorder() >= playerShip.y) {
            playerShip.kill();
        }
        if (enemyFleet.getShipsCount() == 0) {
            playerShip.win();
            stopGameWithDelay();
        }

    }


    private void stopGame(boolean isWin) {
        isGameStopped = true;
        stopTurnTimer();
        if(isWin) {
            showMessageDialog(Color.BLACK, "You are winner", Color.GREEN, 40);
        } else {
            showMessageDialog(Color.BLACK, "You are loser", Color.RED, 40);
        }
    }

    private  void stopGameWithDelay() {
        animationsCount ++;
        if (animationsCount >= 10) {
            stopGame(playerShip.isAlive);
        }

    }

}
