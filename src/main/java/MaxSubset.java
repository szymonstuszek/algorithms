import java.util.Arrays;
import java.util.OptionalInt;

public class MaxSubset {

    public static int maxSubsetSumNoAdjacent(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        if (array.length == 1) {
            return array[0];
        }

        if (array.length == 2) {
            return Math.max(array[0], array[1]);
        }

        int[] maxSums = Arrays.copyOf(array, array.length);

        if (maxSums[0] > maxSums[1]) {
            maxSums[1] = maxSums[0];
        }

        for (int i = 2; i < maxSums.length; i++) {
            maxSums[i] = maxSums[i - 1] > maxSums[i - 2] + array[i]
                    ? maxSums[i - 1] : maxSums[i - 2] + array[i];
        }

        return Arrays.stream(maxSums)
                .max().getAsInt();
    }
}
