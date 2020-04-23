
public class SubarraySort {
    public static int[] subarraySort(int[] array) {
        int minOutOfOrder = Integer.MAX_VALUE;
        int maxOutOfOrder = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (isOutOfOrder(i, array)) {
                int current = array[i];
                if (current < minOutOfOrder) {
                    minOutOfOrder = current;
                }
                if (current > maxOutOfOrder) {
                    maxOutOfOrder = current;
                }
            }
        }
        if (minOutOfOrder == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }

        int leftIndex = 0;
        while (minOutOfOrder >= array[leftIndex]) {
            leftIndex++;
        }

        int rightIndex = array.length - 1;
        while (maxOutOfOrder <= array[rightIndex]) {
            rightIndex--;
        }

        return new int[]{leftIndex, rightIndex};
    }

    private static boolean isOutOfOrder(int index, int[] array) {
        if (index == 0) {
            return array[0] > array[1];
        }
        if (index == array.length - 1) {
            return array[index] < array[index - 1];
        }
        return array[index] < array[index - 1] || array[index] > array[index + 1];
    }
}
