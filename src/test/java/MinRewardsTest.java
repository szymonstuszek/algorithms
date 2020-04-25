import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinRewardsTest {

    @Test
    public void testScoresWithExampleArray() {
        int[] example = new int[]{8, 4, 2, 1, 3, 6, 7, 9, 5};
        int expectedResult = 25;
        int result = MinRewards.minRewards(example);
        Assert.assertEquals(expectedResult, result);
    }

}
