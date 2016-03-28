package magic_balls.rules;

import magic_balls.ball.Ball;
import magic_balls.ball.Balls;
import magic_balls.ball.Colors;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class YellowBallRulesTest {

    @org.junit.Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void canNotAddYellowBallsAtFirst() throws YellowBallsLimitExceeded {
        thrown.expect(YellowBallsLimitExceeded.class);
        YellowBallRules yellowBallRules = new YellowBallRules(0.4);
        yellowBallRules.canBallBeAdded(new Balls(), new Ball(Colors.YELLOW));
    }

    @Test
    public void canAddYellowBallsAfterSecondBall() throws YellowBallsLimitExceeded {
        YellowBallRules yellowBallRules = new YellowBallRules(0.4);
        Balls balls = new Balls();
        balls.add(new Ball(Colors.BLUE));
        balls.add(new Ball(Colors.BLUE));
        Assert.assertTrue(yellowBallRules.canBallBeAdded(balls, new Ball(Colors.YELLOW)));
    }
}