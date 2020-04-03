import org.junit.Assert;
import org.junit.Test;

public class SingleCycleCheckTest {

    @Test
    public void testSingleCycleCheck() {

        Assert.assertFalse(SingleCycleCheck.hasSingleCycle(new int[]{1,1,1,1,2}));
    }

}
