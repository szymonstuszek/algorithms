import org.junit.Assert;
import org.junit.Test;

class HeapSortTest {


    @Test
    public void testHeapSort() {
        int[] array = {8, 5, 2, 9, 5, 6, 3};
        int[] expected = {2, 3, 5, 5, 8, 9};

        int[] result = HeapSort.heapSort(array);
        Assert.assertEquals(expected, result);
    }

}
