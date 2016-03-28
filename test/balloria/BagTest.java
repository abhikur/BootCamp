package balloria;

import exceptions.NoMoreBallsAllowed;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;


public class BagTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldNotAddRedBallAtFirst() throws NoMoreBallsAllowed {
        thrown.expect(NoMoreBallsAllowed.class);
        thrown.expectMessage("No More RED balls allowed");
        Bag bag = new Bag(12);
        Ball redBall = new Ball(Color.RED);
        bag.add(redBall);
    }

    @Test
    public void shouldNotAddMoreThanThreeGreenBalls() throws NoMoreBallsAllowed {
        thrown.expect(NoMoreBallsAllowed.class);
        thrown.expectMessage("No More GREEN balls allowed");
        Bag bag = new Bag(12);
        Ball greenBall = new Ball(Color.GREEN);
        bag.add(greenBall);
        bag.add(greenBall);
        bag.add(greenBall);
        bag.add(greenBall);
    }

    @Test
    public void shouldAddBlueBallsInTheRemainingSpace() throws NoMoreBallsAllowed {
        Bag bag = new Bag(12);
        Ball greenBall = new Ball(Color.GREEN);
        Ball redBall = new Ball(Color.RED);
        Ball blueBall = new Ball(Color.BLUE);
        bag.add(greenBall);
        bag.add(greenBall);
        bag.add(greenBall);
        bag.add(redBall);
        bag.add(redBall);
        bag.add(redBall);
        bag.add(redBall);
        bag.add(redBall);
        bag.add(blueBall);
        bag.add(blueBall);
        bag.add(blueBall);
        bag.add(blueBall);
        assertEquals(3, bag.noOfBalls(greenBall));
        assertEquals(5, bag.noOfBalls(redBall));
        assertEquals(4, bag.noOfBalls(blueBall));
    }

    @Test
    public void shouldAllowYellowBallsToFortyPercentOfNumberOfBallsPresentInTheBag() throws NoMoreBallsAllowed {
        Bag bag = new Bag(12);
        Ball greenBall = new Ball(Color.GREEN);
        Ball redBall = new Ball(Color.RED);
        Ball yellowBall = new Ball(Color.YELLOW);
        bag.add(greenBall);
        bag.add(greenBall);
        bag.add(redBall);
        bag.add(redBall);
        bag.add(redBall);
        bag.add(yellowBall);
        bag.add(yellowBall);
        assertEquals(2,bag.noOfBalls(yellowBall));
    }

    @Test
    public void shouldNotAddYellowBallsMoreThanFortyPercentOfNumberOfBallsPresentInTheBag() throws NoMoreBallsAllowed {
        thrown.expect(NoMoreBallsAllowed.class);
        thrown.expectMessage("No More YELLOW balls allowed");
        Bag bag = new Bag(12);
        Ball greenBall = new Ball(Color.GREEN);
        Ball redBall = new Ball(Color.RED);
        Ball yellowBall = new Ball(Color.YELLOW);
        bag.add(greenBall);
        bag.add(greenBall);
        bag.add(redBall);
        bag.add(redBall);
        bag.add(redBall);
        bag.add(yellowBall);
        bag.add(yellowBall);
        bag.add(yellowBall);
    }

    @Test
    public void shouldGiveTheSummaryOfTheBag() throws NoMoreBallsAllowed {
        Bag bag = new Bag(12);
        Ball greenBall = new Ball(Color.GREEN);
        Ball redBall = new Ball(Color.RED);
        Ball yellowBall = new Ball(Color.YELLOW);
        bag.add(greenBall);
        bag.add(greenBall);
        bag.add(redBall);
        bag.add(redBall);
        bag.add(redBall);
        bag.add(yellowBall);
        bag.add(yellowBall);
        assertEquals(   "Bag  : 7balls\n"+
                        "Red  : 3balls\n"+
                        "Green  : 2balls\n"+
                        "Blue  : 0balls\n"+
                        "Yellow  : 2balls",bag.summary());
    }

//    @Test
//    public void shouldGiveTheSummaryInOrderOdTheirAdditionToTheBag() throws NoMoreBallsAllowed {
//        Bag bag = new Bag(12);
//        Ball greenBall = new Ball(Color.GREEN);
//        Ball redBall = new Ball(Color.RED);
//        Ball yellowBall = new Ball(Color.YELLOW);
//        bag.add(greenBall);
//        bag.add(greenBall);
//        bag.add(redBall);
//        bag.add(redBall);
//        bag.add(yellowBall);
//        bag.add(redBall);
//        bag.add(yellowBall);
//        assertEquals("Bag  : 7balls\n"+
//                "2G,2R,1Y,1R,1Y",bag.orderedSummary());
//    }
}