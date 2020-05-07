package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.games.spaceinvaders.Direction;
import com.javarush.games.spaceinvaders.ShapeMatrix;

public class Boss extends EnemyShip{
    private int frameCount = 0;

    public Boss(double x, double y) {
        super(x, y);
        setAnimatedView(true, ShapeMatrix.BOSS_ANIMATION_FIRST, ShapeMatrix.BOSS_ANIMATION_SECOND);
        score = 100;
    }

    @Override
    public void nextFrame() {
        frameCount ++;
        if(!isAlive || (frameCount % 10 == 0)) {
            super.nextFrame();
        }
    }

    @Override
    public Bullet fire() {
        if (!isAlive) {
            return null;
        }
        return new Bullet(matrix == ShapeMatrix.BOSS_ANIMATION_FIRST ? x + 6 : x , y + height, Direction.DOWN);
    }

    @Override
    public void kill() {
        if (!isAlive) {
            return;
        }
        isAlive = false;
        setAnimatedView(false, ShapeMatrix.KILL_BOSS_ANIMATION_FIRST, ShapeMatrix.KILL_BOSS_ANIMATION_SECOND, ShapeMatrix.KILL_BOSS_ANIMATION_THIRD);
    }
}
