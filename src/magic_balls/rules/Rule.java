package magic_balls.rules;

import magic_balls.ball.Ball;
import magic_balls.ball.Balls;

public interface Rule {
    boolean canBallBeAdded(Balls balls, Ball ball) throws YellowBallsLimitExceeded, RedBallsLimitExceeded, GreenBallsLimitExceeded, BlueBallsLimitExceeded;
}
