import org.junit.Assert;
import org.junit.Test;

public class WaterAreaTest {

    @Test
    public void testWaterArea() {
        int[] heights = {0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3};

        int expected = 48;
        int result = WaterArea.waterArea(heights);

        Assert.assertEquals(expected, result);
    }

}
