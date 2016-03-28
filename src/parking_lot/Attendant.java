package parking_lot;

import java.util.ArrayList;
import java.util.List;

public class Attendant {
    List<ParkingLot> listOfParkingLots = new ArrayList<>();
    private Assistant assistant;

    public Attendant(Assistant assistant) {
        this.assistant = assistant;
    }

    public void add(ParkingLot parkingLot) {
        listOfParkingLots.add(parkingLot);
    }

    public int totalParkingLots() {
        return listOfParkingLots.size();
    }

    public void park(Object car) throws SpaceIsFull {
        int index = 0;
        ParkingLot parkingLot = listOfParkingLots.get(index);
        if(parkingLot.isFull())
            parkingLot  = listOfParkingLots.get(++index);
        parkingLot.addCar(car);
        assistant.updateParkingLotRecord(listOfParkingLots);
    }

    public int numberOfCarsInParking() {
        int totalCars = 0;
        for (ParkingLot parkingLot : listOfParkingLots) {
            totalCars += parkingLot.numberOFCarsParked();
        }
        return totalCars;
    }
}
