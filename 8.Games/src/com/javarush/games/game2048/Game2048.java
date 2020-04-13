package com.javarush.games.game2048;
import com.javarush.engine.cell.*;

public class Game2048 extends Game{
    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];
    @Override
    public void initialize() {
        super.initialize();
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
    }
    private void createGame(){
        createNewNumber();
        createNewNumber();
    }
    private void drawScene(){
        for (int i = 0; i < gameField.length; i++)
        {
            for(int j = 0; j < gameField[i].length; j ++)
            {
                setCellColoredNumber(i, j, gameField[j][i]);
            }
        }
    }
    private void createNewNumber(){
        int i;
        int j;
        do {
            i = getRandomNumber(SIDE);
            j = getRandomNumber(SIDE);
        }while (gameField[i][j] != 0);
        int count = getRandomNumber(10);
        if(count >= 0 && count < 9) gameField[i][j] = 2;
        else gameField[i][j] = 4;

    }
    private Color getColorByValue(int value){
        Color color = Color.BISQUE;
        switch (value){
            case 2: {color = Color.PINK;break;}
            case 4: {color = Color.VIOLET;break;}
            case 8: {color = Color.BLUE;break;}
            case 16: {color = Color.TURQUOISE;break;}
            case 32: {color = Color.GREEN;break;}
            case 64: {color = Color.LIGHTGREEN;break;}
            case 128: {color = Color.YELLOW;break;}
            case 256: {color = Color.PEACHPUFF;break;}
            case 512: {color = Color.ORANGE;break;}
            case 1024: {color = Color.FUCHSIA;break;}
            case 2048: {color = Color.PURPLE;break;}
        }
        return color;
    }
    private void setCellColoredNumber(int x, int y, int value){
        setCellValueEx(x, y, getColorByValue(value), ((value == 0) ? "" : "" + value));
    }
    private boolean compressRow(int[] row){
        boolean flagCheck = false;
        for (int i = 0; i < row.length ; i++) {
            if (row[i] == 0){
                for (int j = i; j < row.length ; j++)
                    if (row[j] != 0){
                        int tmp = row[j];
                        row[i] = tmp;
                        row[j] = 0;
                        flagCheck = true;
                        break;
                    }
            }else{}
        }
        return flagCheck;
    }
}
