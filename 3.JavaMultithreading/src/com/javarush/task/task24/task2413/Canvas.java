package com.javarush.task.task24.task2413;

public class Canvas {
    private int width, height;
    private char[][] matrix;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        matrix = new char[height + 2][width + 2];
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }

    public void setPoint(double x, double y, char c){
        /*
        В методе надо:
        а) округлить x и y до целых чисел
        б) занести в matrix[y][x] значение с
        в) ничего не делать, если x < 0 или y < 0 или y >= matrix.length или x >= matrix[0].length
        */
        int xi = (int)Math.round(x);
        int yi = (int)Math.round(y);
        if (xi >= 0 && yi >= 0 && yi < matrix.length && xi < matrix[0].length){
            matrix[yi][xi] = c;
        }
    }

    public void drawMatrix(double x, double y, int[][] matrix, char c){
        /*
        В методе надо:
        а) с помощью двух вложенных циклов пройтись по всем ячейкам переданной картинки
        б) если значение ячейки элемента [i][j] полученной матрицы не равно 0, то покрасить в матрице объекта Canvas точку (x+j, y+i) в цвет c:
        setPoint(x+j, y+i, c)
         */
        for (int i = 0; i < matrix.length; i ++){
            for (int j = 0; j < matrix[i].length; j ++){
                if (matrix[i][j] != 0 ) setPoint(x + j, y + i, c);
            }
        }
    }
    public void clear(){
        matrix = new char[height + 2][width + 2];
    }

    public void print(){
        for (int i = 0; i < matrix.length; i ++){
            for (int j = 0; j < matrix[i].length; j ++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

}
