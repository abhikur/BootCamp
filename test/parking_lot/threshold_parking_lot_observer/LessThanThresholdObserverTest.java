package parking_lot.threshold_parking_lot_observer;

import org.junit.Test;
import parking_lot.Assistant;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class LessThanThresholdObserverTest {

    @Test
    public void shouldUpdateTheGivenObserverWhenCarsAreLessThan20Percent() {
        Assistant mock = mock(Assistant.class);
        LessThanThresholdObserver thresholdObserver = new LessThanThresholdObserver(mock, 0.2);
        thresholdObserver.update(1, 5);
        verify(mock).update(1, 5);
    }
}