package magic_balls;

import magic_balls.ball.Ball;
import magic_balls.ball.Colors;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class BallTest {

    @Test
    public void isOfColor() {
        Ball ball = new Ball(Colors.BLUE);
        assertTrue(ball.isOfColor(Colors.BLUE));
    }
}