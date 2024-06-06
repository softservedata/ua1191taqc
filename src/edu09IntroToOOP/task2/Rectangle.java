package edu09IntroToOOP.task2;

public class Rectangle {
        double width;
        double height;
        double angle = 90.0;

    public Rectangle() {
        this.width = 0.0;
        this.height = 0.0;
    }

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getAngle() {
        return angle;
    }

    public double calculateArea() {
        return width * height;
    }


    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    public double getDiagonal() {
        return Math.sqrt(width * width + height * height);
    }

    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(15.0, 20.0);
        System.out.println("Area: " + rect1.calculateArea());
        System.out.println("Perimeter: " + rect1.calculatePerimeter());
        System.out.println("Diagonal: " + rect1.getDiagonal());

    }
}

