import org.junit.Assert;
import org.junit.Test;

public class ShiftedBinarySearchTest {

    @Test
    public void testShiftedBinarySearch() {
        int[] array = {45, 61, 71, 72, 73, 0, 1, 21, 33, 45};
        int target = 33;
        int expected = 8;

        Assert.assertEquals(expected, ShiftedBinarySearch.shiftedBinarySearch(array, target));
    }

    @Test
    public void testShiftedBinarySearch2() {
        int[] array = {61, 71, 72, 73, 0, 1, 21, 33, 45, 45};
        int target = 33;
        int expected = 7;

        Assert.assertEquals(expected, ShiftedBinarySearch.shiftedBinarySearch(array, target));
    }
}
