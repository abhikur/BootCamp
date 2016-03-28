package parking_lot.threshold_parking_lot_observer;

public class GreaterThanThresholdObserver extends ParkingLotObserver {
    private ParkingLotObserver observer;
    private double notifyingFactor;

    public GreaterThanThresholdObserver(ParkingLotObserver observer, double threshold) {
        this.observer = observer;
        this.notifyingFactor = threshold;
    }

    public void update(int numberOFCarsParked, int capacity) {
        System.out.println((double) numberOFCarsParked / capacity >= notifyingFactor);
        if ((double) numberOFCarsParked / capacity >= notifyingFactor)
            observer.update(numberOFCarsParked, capacity);

    }
}
