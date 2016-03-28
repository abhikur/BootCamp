package magic_balls.rules;

import magic_balls.ball.Ball;
import magic_balls.ball.Balls;
import magic_balls.ball.Colors;

public class RedBallRules implements Rule {
    private double factor;

    public RedBallRules(double factor) {
        this.factor = factor;
    }

    @Override
    public boolean canBallBeAdded(Balls balls, Ball ball) throws RedBallsLimitExceeded {
        if(!(balls.getQuantityOf(new Ball(Colors.RED)) < factor * balls.getQuantityOf(new Ball(Colors.GREEN)) - 1))
            throw new RedBallsLimitExceeded();
        return true;
    }
}
