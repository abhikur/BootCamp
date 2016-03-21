package compare;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class UnitOfVolumeTest {

    @Test
    public void stdUnitForLitreShouldBeLitre() {
        assertEquals(UnitOfVolume.LITRE, UnitOfVolume.LITRE.stdUnit());
    }
    @Test
    public void stdUnitForGallonShouldBeLitre() {
        assertEquals(UnitOfVolume.LITRE, UnitOfVolume.GALLON.stdUnit());
    }

    @Test
    public void getInBaseForLitreShouldBeOneLitre() {
        assertEquals(1, UnitOfVolume.LITRE.getInBase(1),0);
    }
    @Test
    public void getInBaseForGallonShouldBeItsEquivalentLitre() {
        assertEquals(3.78, UnitOfVolume.GALLON.getInBase(1),0);
    }
}