

public class ShiftedBinarySearch {

    public static int shiftedBinarySearch(int[] array, int target) {
        return search( array, target, 0, array.length - 1);
    }

    private static int search(int[] array, int target, int left, int right) {
        while (left <= right) {

            int leftNum = array[left];
            int rightNum = array[right];
            int middle = (left + right) / 2;
            int potentialMatch = array[middle];

            if (potentialMatch == target) {
                return middle;
            } else if (leftNum <= potentialMatch) {

                if (leftNum <= target && potentialMatch > target) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }

            } else {

                if (potentialMatch < target && target <= rightNum) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }

        return -1;
    }

}
