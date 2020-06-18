

public class QuickSort {

    public static int[] quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    public static void quickSort(int[] array, int startIdx, int endIdx) {
        if (startIdx >= endIdx) {
            return;
        }

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
        boolean isLeftArraySmaller = right - 1 - startIdx < endIdx - (right + 1);

        if (isLeftArraySmaller) {
            quickSort(array, startIdx, right - 1);
            quickSort(array, right + 1, endIdx);
        } else {
            quickSort(array, right + 1, endIdx);
            quickSort(array, startIdx, right - 1);
        }
    }

    public static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
