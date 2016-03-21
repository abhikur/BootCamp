package chance;

public class Chance {
    private double chance;

    public Chance(double chance) {
        this.chance = chance;
    }

    public Chance and(Chance chanceOfEvent2) {
        return new Chance(this.chance * chanceOfEvent2.chance);
    }

    public Chance not() {
        return new Chance(1 - this.chance);
    }

    public Chance or(Chance other) {
        return this.not().and(other.not()).not();
    }

    @Override
    public String toString() {
        return chance+"";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chance chance1 = (Chance) o;
        return Double.compare(chance1.chance, chance) == 0;

    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(chance);
        return (int) (temp ^ (temp >>> 32));
    }
}
