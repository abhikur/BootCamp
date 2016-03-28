package magic_balls.rules;

import magic_balls.ball.Ball;
import magic_balls.ball.Balls;
import magic_balls.ball.Colors;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BlueBallRulesTest {
    @org.junit.Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void ballCanBeAddedIfTheBagIsEmpty() throws BlueBallsLimitExceeded {
        BlueBallRules blueBallRules = new BlueBallRules(1);
            Assert.assertTrue(blueBallRules.canBallBeAdded(new Balls(), new Ball(Colors.BLUE)));
    }

    @Test
    public void ballCanNotBeAddedMaxLimitReached() throws BlueBallsLimitExceeded {
        thrown.expect(BlueBallsLimitExceeded.class);
        BlueBallRules blueBallRules = new BlueBallRules(0);
            blueBallRules.canBallBeAdded(new Balls(), new Ball(Colors.BLUE));
    }
}