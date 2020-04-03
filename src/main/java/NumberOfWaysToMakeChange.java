import java.util.stream.IntStream;

public class NumberOfWaysToMakeChange {

    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        int[] ways = IntStream.rangeClosed(0, n)
                .map(value -> 0)
                .toArray();
        ways[0] = 1;

        for (int j = 0; j < denoms.length; j++) {
            int currentDenom = denoms[j];
            for (int i = 1; i < ways.length; i++) {

                if (currentDenom <= i) {
                    ways[i] += ways[i - currentDenom];
                }

            }
        }

        return ways[ways.length - 1];
    }
}
