package magic_balls.rules;

import magic_balls.ball.Ball;
import magic_balls.ball.Balls;

import java.util.ArrayList;
import java.util.List;

public class Rules {
    List<Rule> rules = new ArrayList<>();

    public void add(Rule rule) {
        rules.add(rule);
    }

    public void checkAllRulesFollowed(Balls balls, Ball ball) throws BallsLimitExceeded {
        for (Rule rule  : rules) {
            rule.canBallBeAdded(balls, ball);
        }
    }
    
}
