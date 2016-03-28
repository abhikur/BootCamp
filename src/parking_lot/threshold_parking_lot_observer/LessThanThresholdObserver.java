package parking_lot.threshold_parking_lot_observer;

public class LessThanThresholdObserver extends ParkingLotObserver{
    private ParkingLotObserver observer;
    private double threshold;

    public LessThanThresholdObserver(ParkingLotObserver observer, double threshold) {
        this.observer = observer;
        this.threshold = threshold;
    }

    public void update(int numberOFCarsParked, int capacity) {
        if((double)numberOFCarsParked/capacity <= threshold)
            observer.update(numberOFCarsParked, capacity);
    }
}
