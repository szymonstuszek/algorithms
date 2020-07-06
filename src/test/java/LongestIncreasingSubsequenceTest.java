import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequenceTest {

    @Test
    public void testLongestIncreasingSubsequence() {
        int[] input = {5, 7, -24, 12, 10, 2, 3, 12, 5, 6, 35};
        List<Integer> expected = new ArrayList<>();
        expected.add(-24);
        expected.add(2);
        expected.add(3);
        expected.add(5);
        expected.add(6);
        expected.add(35);

        List<Integer> result = LongestIncreasingSubsequence.longestIncreasingSubsequence(input);

        Assert.assertEquals(expected, result);
    }

}
