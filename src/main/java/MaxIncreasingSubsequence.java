import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxIncreasingSubsequence {
    public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
        int[] sums = array.clone();
        int[] sequences = new int[array.length];
        int maxSumIndex = 0;
        Arrays.fill(sequences, Integer.MIN_VALUE);

        for (int i = 0; i < array.length; i++) {
            int currentSum = array[i];
            for (int j = 0; j < i; j++) {
                int valueToCompare = array[j];

                if (valueToCompare < currentSum && sums[j] + currentSum >= sums[i]) {
                    sums[i] = sums[j] + currentSum;
                    sequences[i] = j;
                }

                if (sums[i] > sums[maxSumIndex]) {
                    maxSumIndex = i;
                }
            }
        }

        return buildSequence(array, sequences, maxSumIndex);
    }

    private static List<List<Integer>> buildSequence(int[] array, int[] sequences, int maxSumIndex) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> maxSequence = new ArrayList<>();
        int maxSum = 0;
        int currentIndex = maxSumIndex;

        while (currentIndex != Integer.MIN_VALUE) {
            maxSequence.add(array[currentIndex]);
            maxSum += array[currentIndex];
            currentIndex = sequences[currentIndex];
        }

        answer.add(Arrays.asList(maxSum));
        Collections.reverse(maxSequence);
        answer.add(maxSequence);

        return answer;
    }
}
