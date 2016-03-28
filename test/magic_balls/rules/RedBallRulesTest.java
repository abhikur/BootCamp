package magic_balls.rules;

import magic_balls.ball.Ball;
import magic_balls.ball.Balls;
import magic_balls.ball.Colors;
import org.junit.*;
import org.junit.rules.ExpectedException;


public class RedBallRulesTest {

    @org.junit.Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldNotAddRedBallAsFirstBall() throws RedBallsLimitExceeded {
        thrown.expect(RedBallsLimitExceeded.class);
        RedBallRules redBallRules = new RedBallRules(2);
            redBallRules.canBallBeAdded(new Balls(), new Ball(Colors.RED));
    }

    @Test
    public void shouldAddOnlyOneRedBallWhenOneGreenBallIsPresent() throws RedBallsLimitExceeded {
        RedBallRules redBallRules = new RedBallRules(2);
        Balls balls = new Balls();
        balls.add(new Ball(Colors.GREEN));
            Assert.assertTrue(redBallRules.canBallBeAdded(balls, new Ball(Colors.RED)));
    }

    @Test
    public void shouldNotAddSecondRedBallWhenOneGreenBallIsPresent() throws RedBallsLimitExceeded {
        thrown.expect(RedBallsLimitExceeded.class);
        RedBallRules redBallRules = new RedBallRules(2);
        Balls balls = new Balls();
        balls.add(new Ball(Colors.GREEN));
        balls.add(new Ball(Colors.RED));
            redBallRules.canBallBeAdded(balls, new Ball(Colors.RED));
    }

    @Test
    public void shouldAddThreeRedBallWhenTwoGreenBallArePresent() throws RedBallsLimitExceeded {
        RedBallRules redBallRules = new RedBallRules(2);
        Balls balls = new Balls();
        balls.add(new Ball(Colors.GREEN));
        balls.add(new Ball(Colors.GREEN));
        balls.add(new Ball(Colors.RED));
        balls.add(new Ball(Colors.RED));
            Assert.assertTrue(redBallRules.canBallBeAdded(balls, new Ball(Colors.RED)));
    }
}