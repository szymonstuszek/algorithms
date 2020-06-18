
public class QuickSelect {
    public static int quickselect(int[] array, int k) {
        int position = k - 1;
        return quickselect(array, 0, array.length - 1, position);
    }

    private static int quickselect(int[] array, int startIdx, int endIdx, int position) {

        while(true) {
            int pivot = startIdx;
            int left = startIdx + 1;
            int right = endIdx;

            while (left <= right) {
                if (array[left] >= array[pivot] && array[right] <= array[pivot]) {
                    swap(left, right, array);
                }

                if (array[left] <= array[pivot]) {
                    left++;
                }

                if (array[right] >= array[pivot]) {
                    right--;
                }
            }

            swap(pivot, right, array);

            if (right == position) {
                return array[right];
            } else if (right < position) {
                startIdx = right + 1;
            } else {
                endIdx = right - 1;
            }
        }
    }


    public static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
