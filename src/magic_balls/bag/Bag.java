package magic_balls.bag;

import magic_balls.ball.Ball;
import magic_balls.ball.Balls;
import magic_balls.rules.*;

public class Bag {
    Balls balls = new Balls();
    private Rules rules;
    private int capacity;

    public Bag(Rules rules, int capacity) {
        this.rules = rules;
        this.capacity = capacity;
    }

    public void put(Ball ball) throws NoSpaceAvailableException, BallsLimitExceeded {
        if(isFull())
            throw new NoSpaceAvailableException("Bag is full");
        rules.checkAllRulesFollowed(balls, ball);
        balls.add(ball);
    }

    private boolean isFull() {
        return capacity <= balls.size();
    }

//    public Summary summaries() {

//    }
}
