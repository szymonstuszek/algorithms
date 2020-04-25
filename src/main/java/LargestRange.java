import java.util.HashMap;
import java.util.Map;

public class LargestRange {
    public static int[] largestRange(int[] array) {
        Map<Integer, Boolean> numbersToCheck = new HashMap<>();
        int longestRange = 1;
        int[] range = new int[2];

        for (Integer num : array) {
            numbersToCheck.put(num, true);
        }

        for (int i = 0; i < array.length; i++) {
            int currentNumber = array[i];
            numbersToCheck.put(currentNumber, false);

            int left = currentNumber - 1;
            while (numbersToCheck.containsKey(left) && numbersToCheck.get(left).equals(true)) {
                numbersToCheck.put(left, false);
                left--;
            }

            int right = currentNumber + 1;
            while (numbersToCheck.containsKey(right) && numbersToCheck.get(right).equals(true)) {
                numbersToCheck.put(right, false);
                right++;
            }

            int currentLength = right - left + 1;
            if (currentLength > longestRange) {
                longestRange = currentLength;
                range[0] = left + 1;
                range[1] = right - 1;
            }
        }

        return range;
    }
}
