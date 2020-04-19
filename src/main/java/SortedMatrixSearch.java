public class SortedMatrixSearch {

    public static int[] searchInSortedMatrix(int[][] matrix, int target) {
        int[] result = {-1, -1};
        int rows = matrix.length;
        int columns = matrix[0].length;
        int currentColumnIndex = columns - 1;
        int currentRowIndex = 0;

        while (currentRowIndex < rows && currentColumnIndex >= 0) {
            int currentNumber = matrix[currentRowIndex][currentColumnIndex];

            if (currentNumber == target) {
                result[0] = currentRowIndex;
                result[1] = currentColumnIndex;
                break;
            }

            if (currentNumber > target) {
                currentColumnIndex--;
            } else {
                currentRowIndex++;
            }
        }

        return result;
    }
}
