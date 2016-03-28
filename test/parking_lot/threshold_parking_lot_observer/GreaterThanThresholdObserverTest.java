package parking_lot.threshold_parking_lot_observer;

import org.junit.Test;
import parking_lot.Manager;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class GreaterThanThresholdObserverTest {

    @Test
    public void shouldUpdateGivenObserverWhenConditionMeetsTheThreshold() {
        Manager mock = mock(Manager.class);
        GreaterThanThresholdObserver thresholdObserver = new GreaterThanThresholdObserver(mock, 0.8);
        thresholdObserver.update(1, 1);
        verify(mock).update(1, 1);
    }
}