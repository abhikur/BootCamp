package chance;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChanceTest {
    @Test
    public void toStringRepresentationOfChanceShowChanceInPercentage() {
        Chance chance = new Chance(0.25);
        assertEquals("0.25", chance.toString());
    }

    @Test
    public void andShouldGiveChanceOfTwoEventsOccurredSimultaneously() {
        Chance chanceOfEvent1 = new Chance(0.5);
        Chance chanceOfEvent2 = new Chance(0.35);
        Chance expected = new Chance(0.175);
        assertEquals(expected, chanceOfEvent1.and(chanceOfEvent2));
    }

    @Test
    public void notShouldGiveNotOfChance() {
        Chance chanceOfEvent1 = new Chance(0.25);
        Chance expected = new Chance(0.75);
        assertEquals(expected, chanceOfEvent1.not());
    }

    @Test
    public void orShouldGiveOneOfTheChances() {
        Chance chanceOfEvent1 = new Chance(0.5);
        Chance chanceOfEvent2 = new Chance(0.5);
        Chance expected = new Chance(0.75);
        assertEquals(expected, chanceOfEvent1.or(chanceOfEvent2));
    }

    @Test
    public void chanceOfGettingTailWhenCoinIsFlippedOnceShouldBePointFive() {
        double gettingTail = 1d/2d;
        Chance chanceOfGettingTail = new Chance(gettingTail);
        Chance expected = new Chance(0.5);
        assertEquals(expected, chanceOfGettingTail);
    }

    @Test
    public void chanceOfGettingTailWhenCoinIsFlippedTwiceShouldBePointTwoFive() {
        double gettingTail = 1d/2d;
        Chance chanceOfGettingTail = new Chance(gettingTail);
        Chance expected = new Chance(0.25);
        assertEquals(expected, chanceOfGettingTail.and(chanceOfGettingTail));
    }

    @Test
    public void chanceOfNotGettingTailWhenCoinIsFlippedOnceShouldBePointFive() {
        double gettingTail = 1d/2d;
        Chance chanceOfGettingTail = new Chance(gettingTail);
        Chance expected = new Chance(0.5);
        assertEquals(expected, chanceOfGettingTail.not());
    }

    @Test
    public void chanceOfGettingAtLeastOneTailWhenCoinIsFlippedTwiceShouldBePointSevenFive() {
        double gettingTail = 1d/2d;
        Chance chanceOfGettingTail = new Chance(gettingTail);
        Chance expected = new Chance(0.75);
        assertEquals(expected, chanceOfGettingTail.or(chanceOfGettingTail));
    }
}