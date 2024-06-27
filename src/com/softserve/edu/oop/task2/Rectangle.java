package com.softserve.edu.oop.task2;

public class Rectangle {
    private double width;
    private double height;
    private final double angle = 90.0;

    public Rectangle() {
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getAngle() {
        return angle;
    }

    public double calculatePerimeter(){
        return 2*(width+height);
    }
    public double calculateArea(){
        return width*height;
    }
    public double getDiagonal() {
        return Math.sqrt((width * width) + (height * height));
    }

    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(4,5);
        System.out.println("Rectangle 1:");
        System.out.println("Width: " + rectangle1.getWidth());
        System.out.println("Height: " + rectangle1.getHeight());
        System.out.println("Angle: " + rectangle1.getAngle());
        System.out.println("Area: " + rectangle1.calculateArea());
        System.out.println("Perimeter: " + rectangle1.calculatePerimeter());
        System.out.printf("Diagonal: %.2f ", rectangle1.getDiagonal());
        System.out.println();
    }
}
