/*
Job of this enum -
 - Giving the conversion factor
 */
package compare;

public enum UnitOfVolume implements Unit {
    Litre(1),
    Gallon(3.78);

    private double conversionFactor;

    UnitOfVolume(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    @Override
    public Unit stdUnit() {
        return Litre;
    }
    @Override
    public double getInBase(double quantity) {
        return conversionFactor * quantity;
    }

}
