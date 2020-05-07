package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.Game;
import com.javarush.games.spaceinvaders.Direction;
import com.javarush.games.spaceinvaders.ShapeMatrix;
import com.javarush.games.spaceinvaders.SpaceInvadersGame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EnemyFleet {
    private static final int ROWS_COUNT = 3;
    private static final int COLUMNS_COUNT = 10;
    private static final int STEP = ShapeMatrix.ENEMY.length + 1;

    private List<EnemyShip> ships;

    private Direction direction = Direction.RIGHT;

    public EnemyFleet() {
        createShips();
    }

    private void createShips() {
        ships = new ArrayList<EnemyShip>( ROWS_COUNT * COLUMNS_COUNT);
        for (int x = 0; x < COLUMNS_COUNT; x ++) {
            for (int y = 0; y < ROWS_COUNT; y ++) {
                ships.add(new EnemyShip(x * STEP, y * STEP + 12));
            }
        }
        ships.add(new Boss(STEP * COLUMNS_COUNT / 2 - ShapeMatrix.BOSS_ANIMATION_FIRST.length / 2 - 1, 5));
    }

    public void draw(Game game) {
        for (EnemyShip ship : ships) {
            ship.draw(game);
        }
    }

    private double getLeftBorder() {
        double min = ships.get(0).x;

        for (EnemyShip ships: ships) {
            if (ships.x < min) min = ships.x;
        }

        return min;
    }

    private double getRightBorder() {
        double max = ships.get(0).x + ships.get(0).width;

        for (EnemyShip ships : ships) {
            if ((ships.x + ships.width) > max) max = ships.x + ships.width;
        }
        return max;
    }

    public double getBottomBorder() {
        if (ships.size() == 0) {
            return 0;
        }
        double max = ships.get(0).y + ships.get(0).height;

        for (EnemyShip ships : ships) {
            if ((ships.y + ships.height) > max) max = ships.y + ships.height;
        }
        return max;
    }
    public int getShipsCount() {
        return ships.size();
    }

    private double getSpeed() {
        return (2.0 < (3.0 / ships.size())) ? 2.0 : 3.0 / ships.size();
    }

    public void move() {
        if (ships.size() == 0) {
            return;
        }
        boolean changeDirection = false;
       if (direction == Direction.LEFT && getLeftBorder() < 0) {
                    direction = Direction.RIGHT;
           changeDirection = true;
                } else if( direction == Direction.RIGHT && getRightBorder() > SpaceInvadersGame.WIDTH) {
                    direction = Direction.LEFT;
           changeDirection = true;
       }
        for (EnemyShip ship: ships) {
            ship.move(changeDirection ? Direction.DOWN : direction, getSpeed());
        }
    }

    public Bullet fire(Game game) {
        if (ships.size() == 0 || game.getRandomNumber(100 / SpaceInvadersGame.COMPLEXITY) > 0)  {
            return null;
        }
        return ships.get(game.getRandomNumber(ships.size())).fire();
    }

    public void deleteHiddenShips() {
        Iterator<EnemyShip> shipIterator = ships.iterator();
        while(shipIterator.hasNext()) {

            EnemyShip nextShip = shipIterator.next();
            if(nextShip.isVisible() == false) {
                shipIterator.remove();
            }
        }

    }

    public  int verifyHit(List<Bullet> bullets) {
        if (bullets.size() == 0) {
            return 0;
        }
        int score = 0;
        for (EnemyShip ship : ships) {
            for (Bullet bullet : bullets) {
                if (ship.isAlive && bullet.isAlive && ship.isCollision(bullet)) {
                    score += ship.score;
                    ship.kill();
                    bullet.kill();

                }
            }
        }
        return score;
    }

}
