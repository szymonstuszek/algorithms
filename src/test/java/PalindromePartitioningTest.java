import org.junit.Assert;
import org.junit.Test;

public class PalindromePartitioningTest {


    @Test
    public void testpalindromePartitioningMinCuts() {
        String input = "noonabbad";

        int expected = 2;
        int result = PalindromePartitioning.palindromePartitioningMinCuts(input);
        Assert.assertTrue(expected == result);
    }

}
