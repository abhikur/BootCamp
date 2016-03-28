package magic_balls.rules;

import magic_balls.ball.Ball;
import magic_balls.ball.Balls;

public class GreenBallRules implements Rule{

    private double limitFactor;

    public GreenBallRules(double limitFactor) {
        this.limitFactor = limitFactor;
    }

    @Override
    public boolean canBallBeAdded(Balls balls, Ball ball) throws GreenBallsLimitExceeded {
        if((balls.getQuantityOf(ball) < limitFactor))
            return true;
        throw new GreenBallsLimitExceeded();
    }
}
