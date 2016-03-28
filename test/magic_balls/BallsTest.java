package magic_balls;

import magic_balls.ball.Ball;
import magic_balls.ball.Balls;
import magic_balls.ball.Colors;
import org.junit.Assert;
import org.junit.Test;


public class BallsTest {

    @Test
    public void shouldAddBallToBallsCollection() {
        Ball ball = new Ball(Colors.BLUE);
        Balls balls = new Balls();
        balls.add(ball);
        Assert.assertEquals(1, balls.size());
    }

    @Test
    public void shouldGiveQuantityOfSpecificBall() {
        Balls balls = new Balls();
        Ball b1 = new Ball(Colors.BLUE);
        Ball b2 = new Ball(Colors.BLUE);
        balls.add(b1);
        balls.add(b2);
        Assert.assertEquals(2, balls.getQuantityOf(new Ball(Colors.BLUE)));
    }
}