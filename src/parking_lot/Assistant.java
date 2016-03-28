package parking_lot;

import parking_lot.threshold_parking_lot_observer.ParkingLotObserver;

import java.util.List;

public class Assistant extends ParkingLotObserver {
    private List<ParkingLot> listOfParkingLots;

    public void updateParkingLotRecord(List<ParkingLot> updatedParkingLots) {
        listOfParkingLots = updatedParkingLots;
    }

    @Override
    public void update(int numberOfCarsParked, int capacity) {

    }
}
