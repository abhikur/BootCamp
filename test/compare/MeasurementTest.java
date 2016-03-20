package compare;

import exceptions.DifferentUnitAdditionException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class MeasurementTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void addingTwoLengthsShouldGiveResultantLength() throws DifferentUnitAdditionException {
        Measurement _1inch = new Measurement(1, UnitOfLength.Inch);
        Measurement _2inch = new Measurement(2, UnitOfLength.Inch);
        Measurement expected = new Measurement(3, UnitOfLength.Inch);
        assertEquals(_1inch.add(_2inch, UnitOfLength.Inch), expected);
    }
    @Test
    public void addingTwoVolumeShouldGiveResultantVolume() throws DifferentUnitAdditionException {
        Measurement _1litre = new Measurement(1, UnitOfVolume.Litre);
        Measurement _2litre = new Measurement(2, UnitOfVolume.Litre);
        Measurement expected = new Measurement(3, UnitOfVolume.Litre);
        assertEquals(_1litre.add(_2litre, UnitOfVolume.Litre), expected);
    }
    @Test
    public void twoSameUnitMeasurementsOfSameQuantityShouldBeEqual() {
        Measurement _1litre = new Measurement(1, UnitOfVolume.Litre);
        Measurement _1otherLitre = new Measurement(1, UnitOfVolume.Litre);
        assertEquals(_1litre.compare(_1otherLitre), true);
    }

    @Test
    public void twoDifferentUnitMeasurementsButEqualThroughConversionShouldBeEqual() {
        Measurement _1gallon = new Measurement(1, UnitOfVolume.Gallon);
        Measurement equivalentLitre = new Measurement(3.78, UnitOfVolume.Litre);
        assertEquals(_1gallon.compare(equivalentLitre), true);
    }
    @Test
    public void twoDifferentUnitMeasurementsAndNotEqualThroughConversionShouldNotBeEqual() {
        Measurement _1gallon = new Measurement(1, UnitOfVolume.Gallon);
        Measurement equivalentLitre = new Measurement(3.70, UnitOfVolume.Litre);
        assertEquals(_1gallon.compare(equivalentLitre), false);
    }
    @Test
    public void twoDifferentMeasurementsShouldNotBeEqualInAnyCase() {
        Measurement _1gallon = new Measurement(1, UnitOfVolume.Litre);
        Measurement _1inch = new Measurement(1, UnitOfLength.Inch);
        assertEquals(_1gallon.compare(_1inch), false);
    }
    @Test
    public void twoDifferentMeasurementsWhenAddedShouldThrowException() throws DifferentUnitAdditionException {
        Measurement _1gallon = new Measurement(1, UnitOfVolume.Litre);
        Measurement _1inch = new Measurement(1, UnitOfLength.Inch);
        thrown.expect(DifferentUnitAdditionException.class);
        thrown.expectMessage("Units are not same");
        _1gallon.add(_1inch, UnitOfVolume.Litre);
    }
}