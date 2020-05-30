import org.junit.Test;

public class ContinuousMedianTest {

    @Test
    public void testContinuousMedian() {
        ContinuousMedian.ContinuousMedianHandler handler = new ContinuousMedian.ContinuousMedianHandler();
        handler.insert(5);
        handler.insert(10);
        handler.insert(100);
        handler.insert(200);
        handler.insert(6);
        handler.insert(13);
        handler.insert(14);

        double expected = 11.5;
        double result = handler.getMedian();


        handler.insert(50);


    }

}
