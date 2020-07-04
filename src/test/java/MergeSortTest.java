import org.junit.Assert;
import org.junit.Test;

public class MergeSortTest {

    @Test
    public void testMergeSort() {
        int[] array = {8, 5, 2, 9, 5, 6, 3};

        int[] expected = {2, 3, 5, 5, 6, 8, 9};
        int[] result = MergeSort.mergeSort(array);

        Assert.assertEquals(expected, result);
    }

}
