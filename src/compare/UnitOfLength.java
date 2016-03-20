/*
Job of this enum -
 - Gives the conversion factor
 */
package compare;

public enum UnitOfLength implements Unit {
    Feet(12),
    Inch(1),
    Cm(0.4),
    Mm(0.04);

    private double conversionFactor;

    UnitOfLength(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }
    @Override
    public Unit stdUnit() {
        return Inch;
    }
    @Override
    public double getInBase(double quantity) {
        return conversionFactor * quantity;
    }
}
