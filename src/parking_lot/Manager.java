package parking_lot;

import parking_lot.threshold_parking_lot_observer.ParkingLotObserver;

public class Manager extends ParkingLotObserver {

    @Override
    public void update(int numberOfCarsParked, int capacity) {
        System.out.println("Called");
    }

}
