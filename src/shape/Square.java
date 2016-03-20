package shape;/*
Job of the class -
Operations with the data associate with the class.
 */


import exceptions.InvalidInputException;

public class Square extends Rectangle {

    private Square(double side) {
        super(side, side);
    }

    public static Square createSquare(double side) throws InvalidInputException {
        if (side <= 0)
            throw new InvalidInputException("Expected: positive side\nActual: ", side);
        return new Square(side);
    }
}
