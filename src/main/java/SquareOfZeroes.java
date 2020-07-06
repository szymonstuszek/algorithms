import java.util.List;

public class SquareOfZeroes {
    public static boolean squareOfZeroes(List<List<Integer>> matrix) {
        int n = matrix.size();
        for (int topRow = 0; topRow < n; topRow++) {
            for (int leftCol = 0; leftCol < n; leftCol++) {
                int squareLength = 2;
                while (squareLength <= n - leftCol && squareLength <= n - topRow) {
                    int bottomRow = topRow + squareLength - 1;
                    int rightCol = leftCol + squareLength - 1;
                    if (isSquareOfZeroes(matrix, topRow, leftCol, bottomRow, rightCol)) {
                        return true;
                    }
                    squareLength++;
                }
            }
        }
        return false;
    }

    private static boolean isSquareOfZeroes(List<List<Integer>> matrix, int r1, int c1, int r2, int c2) {
        for (int row = r1; row < r2 + 1; row++) {
            if (matrix.get(row).get(c1) != 0 || matrix.get(row).get(c2) != 0) {
                return false;
            }
        }
        for (int col = c1; col < c2 + 1; col++) {
            if (matrix.get(r1).get(col) != 0 || matrix.get(r2).get(col) != 0) {
                return false;
            }
        }
        return true;
    }
}
