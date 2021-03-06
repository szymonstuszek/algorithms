

public class MaxProfitWithKTransactions {

    public static int maxProfitWithKTransactions(int[] prices, int k) {
        if (prices.length == 0) {
            return 0;
        }

        int[][] profits = new int[k + 1][prices.length];
        for (int t = 1; t < k + 1; t++) {
            int maxSoFar = Integer.MIN_VALUE;
            for (int d = 1; d < prices.length; d++) {
                maxSoFar = Math.max(maxSoFar, profits[t - 1][d - 1] - prices[d - 1]);
                profits[t][d] = Math.max(profits[t][d - 1], maxSoFar + prices[d]);
            }
        }

        return profits[k][prices.length - 1];
    }
}
