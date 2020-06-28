import org.junit.Assert;
import org.junit.Test;


public class MaxProfitWithKTransactionsTest {

    @Test
    public void testMaxProfitWithKTransactions() {
        int[] prices = {5, 11, 3, 50, 60, 90};
        int k = 2;

        int expected = 93;
        int result = MaxProfitWithKTransactions.maxProfitWithKTransactions(prices, k);
        Assert.assertTrue(expected == result);
    }

}
