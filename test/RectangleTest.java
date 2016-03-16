import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RectangleTest {

    @Test
    public void areaOfRectangle3X4ShouldGive12() throws Exception {
        Rectangle rectangle = new Rectangle(3, 4);
        rectangle.calculateArea();
        assertEquals(12, rectangle.calculateArea(), 0);
    }

    @Test
    public void perimeterOfRectangle3X4ShouldGive14() throws Exception {
        Rectangle rectangle = new Rectangle(3.0, 4.0);
        assertEquals(14, rectangle.calculatePerimeter(), 0);
    }
}