package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ship extends GameObject{
    public boolean isAlive = true;

    private boolean loopAnimation = false;

    private int frameIndex;

    private List<int[][]> frames;

    public Ship(double x, double y) {
        super(x, y);
    }

    public void setStaticView(int[][] viewFrame) {
        frames = new ArrayList<int[][]>();
        frames.add(viewFrame);
        frameIndex = 0;
        
        setMatrix(viewFrame);
    }

    public  Bullet fire() {
        return null;
    }

    public void kill() {
        isAlive = false;
    }

    public void nextFrame() {

       frameIndex ++;
        if (frameIndex >= frames.size() && !loopAnimation) {
            return;
        }
        if (frameIndex >= frames.size() && loopAnimation) {
            frameIndex = 0;
        }
        matrix = frames.get(frameIndex);
    }

    @Override
    public void draw(Game game) {
        super.draw(game);
        nextFrame();
    }

    public boolean isVisible() {
        /*
        Метод isVisible() должен возвращать false, если корабль "неживой"
         И frameIndex больше либо равно количеству объектов в списке frames. Иначе — true
         */
        if (!isAlive && frameIndex >= frames.size()) {
            return false;
        } else {
            return true;
        }
    }

    public void setAnimatedView(boolean isLoopAnimation, int[][]... viewFrames) {
        loopAnimation = isLoopAnimation;

        setMatrix(viewFrames[0]);
        frames = Arrays.asList(viewFrames);
        frameIndex = 0;
    }
}
