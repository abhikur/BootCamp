package parking_lot;

import org.junit.Test;


public class AssistantTest {

    @Test
    public void updateParkingLotRecordIfOneCarIsParked() throws SpaceIsFull {
        Assistant assistant = new Assistant();
        Attendant attendant = new Attendant(assistant);
        ParkingLot parkingLot = new ParkingLot(2);
        attendant.add(parkingLot);
        Object car = new Object();
        attendant.park(car);
    }
}