package com.javarush.games.racer.road;

import com.javarush.engine.cell.Game;
import com.javarush.games.racer.PlayerCar;
import com.javarush.games.racer.RacerGame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RoadManager {
    public static final int LEFT_BORDER = RacerGame.ROADSIDE_WIDTH;
    public static final int RIGHT_BORDER = RacerGame.WIDTH - LEFT_BORDER;
    private static final int FIRST_LANE_POSITION = 16;
    private static final int FOURTH_LANE_POSITION = 44;
    private static final int PLAYER_CAR_DISTANCE = 12;

    private List<RoadObject> items = new ArrayList<>();

    private int passedCarsCount = 0;

    public int getPassedCarsCount() {
        return passedCarsCount;
    }

    private RoadObject createRoadObject(RoadObjectType type, int x, int y){
        if (type == RoadObjectType.THORN) {
            return new Thorn(x, y);
        } else
            if (type == RoadObjectType.DRUNK_CAR) {
                return new MovingCar(x, y);
            } else
             {
                return new Car(type, x, y);
            }
    }

    private void addRoadObject(RoadObjectType type, Game game){
        int x = game.getRandomNumber(FIRST_LANE_POSITION, FOURTH_LANE_POSITION);
        int y = -1 * RoadObject.getHeight(type);
        RoadObject roadObject = createRoadObject(type, x, y);
        if (roadObject != null && isRoadSpaceFree(roadObject)) {
            items.add(roadObject);
        }
    }

    private boolean isThornExists() {
        for (RoadObject roadObject : items) {
            if (roadObject instanceof Thorn) {
                return true;
            }
        }
        return false;
    }

    private boolean isMovingCarExists() {
        for (RoadObject roadObject : items) {
            if (roadObject instanceof MovingCar) {
                return true;
            }
        }
        return false;
    }

    private void generateThorn(Game game) {
        int countRandom = game.getRandomNumber(100);
        if (countRandom < 10 && !isThornExists()) {
            addRoadObject(RoadObjectType.THORN, game);
        }
    }

    private  void generateRegularCar(Game game) {
        int countRandom = game.getRandomNumber(100);
        int carTypeNumber = game.getRandomNumber(4);
        if (countRandom < 30) {
            addRoadObject(RoadObjectType.values()[carTypeNumber], game);
        }
    }

    private void generateMovingCar(Game game) {
        int countRandom = game.getRandomNumber(100);
        if (countRandom < 10 && !isMovingCarExists()) {
            addRoadObject(RoadObjectType.DRUNK_CAR, game);
        }
    }

    private void deletePassedItems() {
        Iterator iterator = items.iterator();
        while(iterator.hasNext()){
            RoadObject item = (RoadObject)iterator.next();
            if(item.y >= RacerGame.HEIGHT)
                if (!(item instanceof Thorn)) {
                    passedCarsCount ++;
                }
                iterator.remove();
        }
    }

    private boolean isRoadSpaceFree(RoadObject object) {
        for (RoadObject roadObject : items) {
            if (roadObject.isCollisionWithDistance(object, PLAYER_CAR_DISTANCE)) {
                return false;
            }
        }
        return true;
    }

    public void draw(Game game) {
        for (RoadObject roadObject : items) {
            roadObject.draw(game);
        }
    }

    public void move(int boost) {
        for (RoadObject roadObject : items) {
            roadObject.move(roadObject.speed + boost, items);
        }
        deletePassedItems();
    }

    public void generateNewRoadObjects(Game game) {
        generateThorn(game);
        generateRegularCar(game);
        generateMovingCar(game);
    }

    public boolean checkCrush(PlayerCar playerCar) {
        for (RoadObject gameObject : items) {
            if (gameObject.isCollision(playerCar)) {
                return true;
            }
        }
        return false;
    }
}
