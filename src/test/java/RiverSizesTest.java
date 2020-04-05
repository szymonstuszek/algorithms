import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class RiverSizesTest {
    private int[][] matrix1 = {
            {1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0},
            {1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0},
            {0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1},
            {1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0},
            {1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1},
    };

    @Test
    public void testRiverSizes() {

        List<Integer> riverSizes = RiverSizes.riverSizes(matrix1);
        Collections.sort(riverSizes);
        int[] expected = {1, 1, 2, 2, 5, 21};
        Assert.assertTrue(compare(riverSizes, expected));
    }

    public static boolean compare(List<Integer> arr1, int[] arr2) {
        if (arr1.size() != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.size(); i++) {
            if (arr1.get(i) != arr2[i]) {
                return false;
            }
        }
        return true;
    }

}
