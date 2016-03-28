package balloria;

import com.sun.deploy.util.StringUtils;
import exceptions.NoMoreBallsAllowed;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bag {
    private int capacity;
    private List<Ball> bag = new ArrayList<>();


    public Bag(int capacity) {
        this.capacity = capacity;
    }

    public void add(Ball ball) throws NoMoreBallsAllowed {
        if (ball.isOfColor(Color.GREEN)) {
            int greenBallsLimit = 3;
            addColoredBall(ball, greenBallsLimit, Color.GREEN);
        }
        if (ball.isOfColor(Color.RED)) {
            addColoredBall(ball, ((noOfBalls(new Ball(Color.GREEN)) * 2) - 1), Color.RED);
        }
        if (ball.isOfColor(Color.YELLOW)) {
            int yellowBallsLimit = (int) (bag.size() * 0.4);
            addColoredBall(ball, yellowBallsLimit, Color.YELLOW);
        }
        if (ball.isOfColor(Color.BLUE)) {
            int maxLimit = capacity - noOfBalls(new Ball(Color.RED)) - noOfBalls(new Ball(Color.GREEN));
            addColoredBall(ball, maxLimit, Color.BLUE);
        }
    }

    private void addColoredBall(Ball ball, int maxLimit, Color color) throws NoMoreBallsAllowed {
        if (!(noOfBalls(ball) < maxLimit))
            throw new NoMoreBallsAllowed(color);
        bag.add(ball);
    }


    public int noOfBalls(Ball ball) {
        return Collections.frequency(bag, ball);
    }

    public String summary() {
        return "Bag  : " + bag.size() + "balls\n" +
                "Red  : " + noOfBalls(new Ball(Color.RED)) + "balls\n" +
                "Green  : " + noOfBalls(new Ball(Color.GREEN)) + "balls\n" +
                "Blue  : " + noOfBalls(new Ball(Color.BLUE)) + "balls\n" +
                "Yellow  : " + noOfBalls(new Ball(Color.YELLOW)) + "balls";
    }

    public String orderedSummary() {
        List<String> summary = new ArrayList<>();
        summary.add("Bag  : " + bag.size() + "balls\n");
        Ball previousBall = bag.get(0);
        int count = 0;
        for (Ball ball : bag) {
            if (ball.equals(previousBall)) {
                count++;
            } else {
                summary.add("" + count);
                count = 0;
            }
            previousBall = ball;
        }
        return StringUtils.join(summary, ",");
    }
}
