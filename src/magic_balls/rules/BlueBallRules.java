package magic_balls.rules;

import magic_balls.ball.Ball;
import magic_balls.ball.Balls;
import magic_balls.ball.Colors;

public class BlueBallRules implements Rule{
    private double limitFactor;

    public BlueBallRules(double limitFactor) {
        this.limitFactor = limitFactor;
    }

    @Override
    public boolean canBallBeAdded(Balls balls, Ball ball) throws BlueBallsLimitExceeded {
        if(!(balls.getQuantityOf(new Ball(Colors.BLUE)) < limitFactor))
            throw new BlueBallsLimitExceeded();
        return true;
    }
}
