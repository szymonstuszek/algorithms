

public class MergeSort {

    public static int[] mergeSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int[] auxiliaryArray = array.clone();
        mergeSort(array, 0, array.length - 1, auxiliaryArray);
        return array;
    }

    private static void mergeSort(int[] array, int startIdx, int endIdx, int[] auxiliaryArray) {
        if (startIdx == endIdx) {
            return;
        }
        int middleIdx = (startIdx + endIdx) / 2;
        mergeSort(auxiliaryArray, startIdx, middleIdx, array);
        mergeSort(auxiliaryArray, middleIdx + 1, endIdx, array);
        doMerge(array, startIdx, middleIdx, endIdx, auxiliaryArray);
    }

    private static void doMerge(int[] array, int startIdx, int middleIdx, int endIdx, int[] auxiliaryArray) {
        int k = startIdx;
        int i = startIdx;
        int j = middleIdx + 1;

        while (i <= middleIdx && j <= endIdx) {
            if (auxiliaryArray[i] <= auxiliaryArray[j]) {
                array[k++] = auxiliaryArray[i++];
            } else {
                array[k++] = auxiliaryArray[j++];
            }
        }
        while (i <= middleIdx) {
            array[k++] = auxiliaryArray[i++];
        }
        while (j <= endIdx) {
            array[k++] = auxiliaryArray[j++];
        }
    }
}
