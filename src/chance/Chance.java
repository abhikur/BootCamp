package chance;

public class Chance {
    private double chance;

    public Chance(double chance) {
        this.chance = chance;
    }

    @Override
    public String toString() {
        return chance * 100 + "%";
    }

    public Chance and(Chance chanceOfEvent2) {
        return new Chance(this.chance + chanceOfEvent2.chance);
    }

    public Chance not() {
        return new Chance(1 - this.chance);
    }
}
