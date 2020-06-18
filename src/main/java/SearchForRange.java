public class SearchForRange {
    public static int[] searchForRange(int[] array, int target) {
        int[] result = {-1, -1};
        alteredBinarySearch(array, target, result, 0, array.length - 1, true);
        alteredBinarySearch(array, target, result, 0, array.length - 1, false);
        return result;
    }

    public static void alteredBinarySearch(int[] array, int target, int[] result, int left, int right, boolean goLeft) {
        while (left <= right) {
            int mid = (left + right) / 2;

            if (array[mid] < target) {
                left = mid + 1;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {

                if(goLeft) {

                    if (mid == 0 || array[mid - 1] != target) {
                        result[0] = mid;
                        return;
                    } else {
                        right = mid - 1;
                    }

                } else {

                    if (mid == 0 || array[mid + 1] != target) {
                        result[1] = mid;
                        return;
                    } else {
                        left = mid + 1;
                    }
                }
            }
        }
    }
}
