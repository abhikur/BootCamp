package parking_lot;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class AttendantTest {
    Attendant attendant = new Attendant(new Assistant());
    ParkingLot parkingLotOfCapacityTwo = new ParkingLot(2);
    ParkingLot parkingLotOfCapacityThree = new ParkingLot(3);
    Object car1 = new Object();
    Object car2 = new Object();
    Object car3 = new Object();

    @Before
    public void setup() throws SpaceIsFull {
        attendant.add(parkingLotOfCapacityTwo);
        attendant.add(parkingLotOfCapacityThree);
        attendant.park(car1);
        attendant.park(car2);
        attendant.park(car3);
    }

    @Test
    public void shouldAddParkingLots() {
        assertEquals(2, attendant.totalParkingLots());
    }

    @Test
    public void shouldReturnTotalCarsParkedInAllParkingLots() {
        assertEquals(3, attendant.numberOfCarsInParking());
    }
}