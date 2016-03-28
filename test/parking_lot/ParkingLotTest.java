package parking_lot;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import parking_lot.threshold_parking_lot_observer.GreaterThanThresholdObserver;
import parking_lot.threshold_parking_lot_observer.ParkingLotObserver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ParkingLotTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void canParkCarIfSpaceIsAvailable() throws SpaceIsFull {
        ParkingLot parkingLot = new ParkingLot(2);
        Object car = new Object();
        assertTrue(parkingLot.addCar(car));
    }

    @Test
    public void canNotParkCarIfSpaceIsFull() throws SpaceIsFull {
        thrown.expect(SpaceIsFull.class);
        ParkingLot parkingLot = new ParkingLot(0);
        Object car = new Object();
        parkingLot.addCar(car);
    }

    @Test
    public void shouldGiveTotalCarsInParkingLot() throws SpaceIsFull {
        ParkingLot parkingLot = new ParkingLot(5);
        Object car1 = new Object();
        Object car2 = new Object();
        Object car3 = new Object();
        parkingLot.addCar(car1);
        parkingLot.addCar(car2);
        parkingLot.addCar(car3);
        assertEquals(3, parkingLot.numberOFCarsParked());
    }

    @Test
    public void shouldUpdateTheProvidedObserverWhenConditionIsSatisfied() throws SpaceIsFull {
        ParkingLotObserver mock = mock(ParkingLotObserver.class);
        ParkingLot parkingLot = new ParkingLot(12);
        parkingLot.addParkingLotObserver(mock);
        parkingLot.addCar(new Object());
        verify(mock).update(1, 12);
    }

    @Test
    public void shouldUpdateManagerWhenEightyPercentOfTheLotIsFull() throws SpaceIsFull {
        ParkingLotObserver mock = mock(Manager.class);
        ParkingLotObserver observer = new GreaterThanThresholdObserver(mock,0.8);
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.addParkingLotObserver(observer);
        parkingLot.addCar(new Object());
        verify(mock).update(1, 1);
    }
}