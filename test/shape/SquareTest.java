package shape;

import exceptions.InvalidInputException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SquareTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void squareOfNegativeLengthDoesNotExist() throws InvalidInputException {
        thrown.expect(InvalidInputException.class);
        thrown.expectMessage("Expected: positive side\n" + "Actual: -3.0");
        Square.createSquare(-3);
    }

    @Test
    public void squareOfZeroLengthDoesNotExist() throws InvalidInputException {
        thrown.expect(InvalidInputException.class);
        thrown.expectMessage("Expected: positive side\n" + "Actual: 0.0");
        Square.createSquare(0);
    }

    @Test
    public void areaOfSquareOfPositiveSideShouldGiveSquareOfSide() throws InvalidInputException {
        Square rectangle = Square.createSquare(3);
        Assert.assertEquals(9, rectangle.calculateArea(), 0);
    }

    @Test
    public void perimeterOfSquareOfPositiveSideShouldGiveFourTimesOfSide() throws InvalidInputException {
        Square rectangle = Square.createSquare(3.0);
        Assert.assertEquals(12, rectangle.calculatePerimeter(), 0);
    }
}