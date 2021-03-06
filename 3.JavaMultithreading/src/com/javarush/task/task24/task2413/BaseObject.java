package com.javarush.task.task24.task2413;

public abstract class BaseObject {
    private double x, y, radius;

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    abstract void draw(Canvas canvas);

    abstract void move();

    public boolean isIntersec(BaseObject o){
        //дистанция_между_объектами <= max (радиус_первого_объекта, радиус_второго_объекта)
        return (Math.sqrt((this.x - o.x) * (this.x - o.x) + (this.y - o.y) * (this.y - o.y)) <= Math.max(this.radius, o.radius));
    }
}
