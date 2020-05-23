import org.junit.Assert;
import org.junit.Test;

public class MinNumberOfJumpsTest {

    @Test
    public void testMinNumberOfJumps() {
        int[] array = {3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3};

        int expected = 4;
        int result = MinNumberOfJumps.minNumberOfJumps(array);
        Assert.assertEquals(expected, result);

    }

    @Test
    public void testMinNumberOfJumps2() {
        int[] array = {1, 1};

        int expected = 1;
        int result = MinNumberOfJumps.minNumberOfJumps(array);
        Assert.assertEquals(expected, result);

    }

}
