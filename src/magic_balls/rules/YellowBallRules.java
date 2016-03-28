package magic_balls.rules;

import magic_balls.ball.Ball;
import magic_balls.ball.Balls;
import magic_balls.ball.Colors;

public class YellowBallRules implements Rule{
    private double limitFactor;

    public YellowBallRules(double limitFactor) {
        this.limitFactor = limitFactor;
    }

    @Override
    public boolean canBallBeAdded(Balls balls, Ball ball) throws YellowBallsLimitExceeded {
        if(!(balls.getQuantityOf(new Ball(Colors.YELLOW))+1 < limitFactor*(balls.size()+1)))
            throw new YellowBallsLimitExceeded();
        return true;
    }
}
