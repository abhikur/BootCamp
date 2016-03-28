package exceptions;

import balloria.Color;

public class NoMoreBallsAllowed extends Throwable {
    public NoMoreBallsAllowed(Color color) {
        super("No More "+color+" balls allowed");
    }

    public NoMoreBallsAllowed(int capacity) {
        super("No more space available. Capacity is "+capacity);
    }
}
