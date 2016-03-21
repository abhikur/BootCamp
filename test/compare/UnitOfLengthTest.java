package compare;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class UnitOfLengthTest {

    @Test
    public void stdUnitForFeetShouldBeInch() {
        assertEquals(UnitOfLength.INCH, UnitOfLength.FEET.stdUnit());
    }

    @Test
    public void baseForFeetShouldBeTwelveInches() {
        assertEquals(12, UnitOfLength.FEET.getInBase(1),0);
    }

    @Test
    public void baseForCMShouldBeItsEquivalentInches() {
        assertEquals(0.4, UnitOfLength.CM.getInBase(1),0);
    }
    @Test
    public void baseForMMShouldBeItsEquivalentInches() {
        assertEquals(0.04, UnitOfLength.MM.getInBase(1),0);
    }
    @Test
    public void baseForInchShouldBeOneInch() {
        assertEquals(1, UnitOfLength.INCH.getInBase(1),0);
    }
}