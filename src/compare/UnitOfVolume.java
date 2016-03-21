/*
Job of this enum -
 - Giving the conversion factor
 */
package compare;

public enum UnitOfVolume implements Unit {
    LITRE(1),
    GALLON(3.78);

    private double conversionFactor;

    UnitOfVolume(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    @Override
    public Unit stdUnit() {
        return LITRE;
    }
    @Override
    public double getInBase(double quantity) {
        return conversionFactor * quantity;
    }

}
