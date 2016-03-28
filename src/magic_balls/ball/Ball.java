package magic_balls.ball;

public class Ball {
    private Colors color;

    public Ball(Colors color) {
        this.color = color;
    }

    public boolean isOfColor(Colors color) {
        return this.color == color;
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
