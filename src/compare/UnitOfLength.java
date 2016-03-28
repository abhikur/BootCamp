/*
Job of this enum -
 - Gives the conversion factor
 */
package compare;

public enum UnitOfLength implements Unit{
    FEET(12),
    INCH(1),
    CM(0.4),
    MM(0.04);

    private double conversionFactor;

    UnitOfLength(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }
    @Override
    public Unit stdUnit() {
        return INCH;
    }
    @Override
    public double getInBase(double quantity) {
        return conversionFactor * quantity;
    }
}

