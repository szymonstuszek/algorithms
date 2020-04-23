import org.junit.Test;

import static org.junit.Assert.*;

public class SubarraySortTest {

    @Test
    public void testSubarraySort() {
        SubarraySort.subarraySort(new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19});
    }

    @Test
    public void testSubarraySort2() {
        SubarraySort.subarraySort(new int[]{1, 2, 4, 7, 10, 11, 7, 12, 7, 7, 16, 18, 19});
    }

}
