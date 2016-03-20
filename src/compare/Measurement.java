package compare;

import exceptions.DifferentUnitAdditionException;

/*
Data associated -
 - quantity
 - unit

Job of this class -
 - adding two measurements
 - comparing two measurements
 */
public class Measurement {

    private double quantity;
    private Unit unit;

    public Measurement(double quantity, Unit unit) {
        this.quantity = quantity;
        this.unit = unit;
    }

    public Measurement add(Measurement otherMeasurement, Unit baseUnit) throws DifferentUnitAdditionException {
        if(this.unit.getClass() != otherMeasurement.unit.getClass())
            throw new DifferentUnitAdditionException("Units are not same");
        double firstQuantity = this.convertToBase().quantity;
        double secondQuantity = otherMeasurement.convertToBase().quantity;
        return new Measurement(firstQuantity + secondQuantity, baseUnit);
    }

    private Measurement convertToBase() {
        double quantityInStdUnit = this.unit.getInBase(this.quantity);
        return new Measurement(quantityInStdUnit, unit.stdUnit());
    }

    public boolean compare(Measurement otherMeasurement) {
        if(this.unit.getClass() != otherMeasurement.unit.getClass()) return false;
        return this.convertToBase().equals(otherMeasurement.convertToBase());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Measurement other = (Measurement) o;
        if (Math.abs(other.quantity - quantity) > 0.001) return false;
        return unit == other.unit;

    }

}
