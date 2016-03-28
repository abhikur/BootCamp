package balloria;

public class Ball {
    private Color color;

    public Ball(Color color) {
        this.color = color;
    }

    public boolean isOfColor(Color givenColor) {
        return color == givenColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ball ball = (Ball) o;

        return color == ball.color;

    }

    @Override
    public int hashCode() {
        return color.hashCode();
    }
}
