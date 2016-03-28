package magic_balls.ball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Balls {
    List<Ball> balls = new ArrayList<>();

    public void add(Ball ball) {
        balls.add(ball);
    }

    public int size() {
        return balls.size();
    }

    public int getQuantityOf(Ball ball) {
        return Collections.frequency(balls, ball);
    }
}
