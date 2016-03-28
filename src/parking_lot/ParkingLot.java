package parking_lot;

import parking_lot.threshold_parking_lot_observer.ParkingLotObserver;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private int capacity;
    List<ParkingLotObserver> parkingLotObserver = new ArrayList<>();
    private List<Object> listOfCars = new ArrayList<>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public boolean addCar(Object car) throws SpaceIsFull {
        if(isFull())
            throw new SpaceIsFull();
        listOfCars.add(car);
        updateParkingLotObservers();
        return true;
    }

    private void updateParkingLotObservers() {
        for (ParkingLotObserver lotObserver : parkingLotObserver) {
                lotObserver.update(numberOFCarsParked(), capacity);
        }
    }

    public boolean isFull() {
        return capacity <= listOfCars.size();
    }

    public int numberOFCarsParked() {
        return listOfCars.size();
    }

    public void addParkingLotObserver(ParkingLotObserver observer) {
        parkingLotObserver.add(observer);
    }
}
