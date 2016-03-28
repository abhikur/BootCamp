package magic_balls.rules;
import magic_balls.ball.Ball;
import magic_balls.ball.Balls;
import magic_balls.ball.Colors;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;


public class GreenBallRulesTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldAddTheFirstGreenBall() throws GreenBallsLimitExceeded {
        GreenBallRules greenBallRules = new GreenBallRules(3);
        Balls balls = new Balls();
        Ball greenBall = new Ball(Colors.GREEN);
        assertTrue(greenBallRules.canBallBeAdded(balls, greenBall));
    }

    @Test
    public void shouldThrowExceptionIfMoreThanThreeGreenBallsAdded() throws GreenBallsLimitExceeded {
        thrown.expect(GreenBallsLimitExceeded.class);
        Balls mockedBalls = Mockito.mock(Balls.class);
        when(mockedBalls.getQuantityOf(new Ball(Colors.GREEN))).thenReturn(3);
        Ball ball = new Ball(Colors.GREEN);
        GreenBallRules greenBallRules = new GreenBallRules(3);
        greenBallRules.canBallBeAdded(mockedBalls, ball);
    }
}