import exceptions.InvalidInputException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class RectangleTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void rectangleOfNegativeLengthDoesNotExist() throws InvalidInputException {
        thrown.expect(InvalidInputException.class);
        thrown.expectMessage("Expected: positive length\n" + "Actual: -3.0");
        Rectangle.createRectangle(-3, 4);
    }

    @Test
    public void rectangleOfZeroLengthDoesNotExist() throws InvalidInputException {
        thrown.expect(InvalidInputException.class);
        thrown.expectMessage("Expected: positive length\n" + "Actual: 0.0");
        Rectangle.createRectangle(0, 4);
    }

    @Test
    public void rectangleOfNegativeWidthDoesNotExist() throws InvalidInputException {
        thrown.expect(InvalidInputException.class);
        thrown.expectMessage("Expected: positive width\n" + "Actual: -4.0");
        Rectangle.createRectangle(3, -4);
    }

    @Test
    public void rectangleOfZeroWidthDoesNotExist() throws InvalidInputException {
        thrown.expect(InvalidInputException.class);
        thrown.expectMessage("Expected: positive width\n" + "Actual: 0.0");
        Rectangle.createRectangle(3, 0);
    }

    @Test
    public void areaOfRectangleOfPositiveSidesShouldGiveTheirMultiplication() throws InvalidInputException {
        Rectangle rectangle = Rectangle.createRectangle(3, 4);
        assertEquals(12, rectangle.calculateArea(), 0);
    }

    @Test
    public void perimeterOfRectangleOfPositiveSidesShouldGiveDoubleOfTheirAddition() throws InvalidInputException {
        Rectangle rectangle = Rectangle.createRectangle(3.0, 4.0);
        assertEquals(14, rectangle.calculatePerimeter(), 0);
    }

}