import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;


class QuickSelectTest {

    @Test
    public void testQuickSelect() {
        int[] array = {8,5,2,9,7,6,3};
        int k = 3;
        int expected = 5;

        int result = QuickSelect.quickselect(array, k);


        Assert.assertEquals(expected, result);
    }
}
