import java.util.Arrays;
import java.util.stream.IntStream;

public class MinNumberOfCoinsToMakeChange {

    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        Arrays.sort(denoms);
        int[] minChange = IntStream.rangeClosed(0, n)
                .map(number -> Integer.MAX_VALUE)
                .toArray();

        minChange[0] = 0;

        for (int i = 0; i < denoms.length; i++ ) {
            int currentDenom = denoms[i];

            for (int j = 1; j < minChange.length; j++) {

                if (currentDenom <= j ) {

                    int minNumberOfCoins = Math.min(minChange[j], 1 + minChange[j - currentDenom]);

                    if (minNumberOfCoins < minChange[j] && minNumberOfCoins > 0) {
                        minChange[j] = minNumberOfCoins;
                    }
                }
            }
        }


        return minChange[n] == Integer.MAX_VALUE ? -1 : minChange[n];
    }
}
