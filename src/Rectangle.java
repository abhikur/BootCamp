/*
Job of the class -
Operations with the data associate with the class.
 */


import exceptions.InvalidInputException;

public class Rectangle {
    private final double length;
    private final double width;

    private Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public static Rectangle createRectangle(double length, double width) throws InvalidInputException {
        if (length <= 0)
            throw new InvalidInputException("Expected: positive length\nActual: ",length);
        if(width <= 0)
            throw new InvalidInputException("Expected: positive width\nActual: ",width);
        return new Rectangle(length, width);
    }

    public double calculateArea() {
        return length * width;
    }

    public double calculatePerimeter() {
        return 2 * (length + width);
    }

}
