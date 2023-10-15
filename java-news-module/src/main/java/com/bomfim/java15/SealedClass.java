package com.bomfim.java15;

/**
 * <a href="https://openjdk.org/jeps/360">JEP 360: Sealed Classes (Preview)</a>
 */
public class SealedClass {

    public double calculateArea(Shape shape) {
        if (shape instanceof Circle circle) {
            circle.printCircleInfo();
            return shape.calculateArea();
        } else if (shape instanceof Rectangle rectangle) {
            rectangle.printRectangleInfo();
            return shape.calculateArea();
        } else if (shape instanceof Square square) {
            square.printSquareInfo();
            return shape.calculateArea();
        } else {
            return 0;
        }
    }

    public abstract static sealed class Shape
            permits Circle, Rectangle, Square {
        abstract double calculateArea();
    }

    public static final class Circle extends Shape {
        private final double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        public void printCircleInfo() {
            System.out.println("Print Circle information: Area = PI * radius*radius");
        }

        @Override
        public double calculateArea() {
            return (Math.PI * Math.pow(radius, 2));
        }
    }

    public static sealed class Rectangle extends Shape
            permits FilledRectangle {
        private final double width;
        private final double height;

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        public void printRectangleInfo() {
            System.out.println("Print Rectangle information: Area = width * height");
        }

        @Override
        public double calculateArea() {
            return width * height;
        }
    }

    public static non-sealed class Square extends Shape {
        private final double side;

        public Square(double side) {
            this.side = side;
        }


        public void printSquareInfo() {
            System.out.println("Print Rectangle information: Area = side*side");
        }

        @Override
        public double calculateArea() {
            return Math.pow(side, 2);
        }
    }

    public class FilledSquare extends Square { //subclass from non-sealed class have the same behavior of normal class.
        public FilledSquare(double side) {
            super(side);
        }
    }

    public final class FilledRectangle extends Rectangle { //subclass from Sealed class should be final or non-sealed

        public FilledRectangle(double width, double height) {
            super(width, height);
        }
    }


}
