package magic_balls.bag;

import magic_balls.ball.Ball;
import magic_balls.ball.Colors;
import magic_balls.rules.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class BagTest {
    private Rules rules = new Rules();
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldThrowExceptionWhilePuttingBallWhenThereIsNoSpaceInBag() throws NoSpaceAvailableException, BallsLimitExceeded {
        thrown.expect(NoSpaceAvailableException.class);
        rules.add(new GreenBallRules(3));
        Bag bag = new Bag(rules, 0);
        bag.put(new Ball(Colors.GREEN));
    }

    @Test
    public void shouldThrowExceptionWhenRedBallPutAsFirstBall() throws  NoSpaceAvailableException, BallsLimitExceeded {
        thrown.expect(RedBallsLimitExceeded.class);
        rules.add(new RedBallRules(2));
        Bag bag = new Bag(rules, 1);
        bag.put(new Ball(Colors.RED));
    }

    @Test
    public void shouldThrowExceptionWhenYellowBallPutAsFirstBall() throws NoSpaceAvailableException, BallsLimitExceeded {
        thrown.expect(YellowBallsLimitExceeded.class);
        rules.add(new YellowBallRules(0.4));
        Bag bag = new Bag(rules, 1);
        bag.put(new Ball(Colors.YELLOW));
    }

//    @Test
//    public void shouldSummariesTheBallsInsideBagInUnorderedWay() throws NoSpaceAvailableException, BallsLimitExceeded {
//        Rules rules = new Rules();
//        rules.add(new GreenBallRules(3));
//        Bag bag = new Bag(rules, 4);
//        bag.put(new Ball(Colors.GREEN));
//        bag.put(new Ball(Colors.GREEN));
//        Summary summary = bag.summaries();
//    }
}