import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class QuickSortTest {

    @Test
    public void testQuickSort() {
        int[] array = {8, 5, 2, 9, 5, 6, 3};
        int[] expected = {2, 3, 5, 5, 6, 8, 9};

        int[] result = QuickSort.quickSort(array);


        Assert.assertTrue(Arrays.equals(expected, result));
    }

}
