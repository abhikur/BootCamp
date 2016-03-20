package chance;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChanceTest {
    @Test
    public void toStringRepresentationOfChanceShowChanceInPercentage() {
        Chance chance = new Chance(0.25);
        assertEquals("25.0%", chance.toString());
    }

    @Test
    public void shouldGiveChanceOfTwoEventsOccurredSimultaneously() {
        Chance chanceOfEvent1 = new Chance(0.5);
        Chance chanceOfEvent2 = new Chance(0.35);
        assertEquals("85.0%", chanceOfEvent1.and(chanceOfEvent2).toString());
    }

    @Test
    public void shouldGiveNotOfChance() {
        Chance chanceOfEvent1 = new Chance(0.25);
        assertEquals("75.0%", chanceOfEvent1.not().toString());
    }
}