import java.util.*;

public class RiverSizes {

    public static List<Integer> riverSizes(int[][] matrix) {
        List<Integer> riverSizes = new ArrayList<>();
        boolean[][] visits = new boolean[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {

                if (visits[row][column]) {
                    continue;
                } else if(matrix[row][column] == 0){
                    visits[row][column] = true;
                } else {
                    int riverSize = calculateRiverSize(matrix, visits, row, column);
                    riverSizes.add(riverSize);
                }
            }
        }

        return riverSizes;
    }

    private static int calculateRiverSize(int[][] matrix, boolean[][] visits, int row, int column) {
        ArrayDeque<int[]> coordinatesToVisit = new ArrayDeque<>();
        coordinatesToVisit.add(new int[]{row, column});
        int riverSize = 0;

        while (!coordinatesToVisit.isEmpty()) {
            int[] coordinate = coordinatesToVisit.poll();
            row = coordinate[0];
            column = coordinate[1];
            visits[row][column] = true;
            if (matrix[row][column] == 1) {
                riverSize++;
            }

            //go up
            if (row - 1 >= 0) {
                if (!visits[row - 1][column]) {
                    visits[row - 1][column] = true;
                    if (matrix[row - 1][column] == 1) {
                        coordinatesToVisit.add(new int[]{row - 1, column});
                    }
                }
            }

            //go right
            if (column + 1 < matrix[0].length) {
                if (!visits[row][column + 1]) {
                    visits[row][column + 1] = true;
                    if (matrix[row][column + 1] == 1) {
                        coordinatesToVisit.add(new int[]{row, column + 1});
                    }
                }
            }

            //go down
            if (row + 1 < matrix.length) {
                if (!visits[row + 1][column]) {
                    visits[row + 1][column] = true;
                    if (matrix[row + 1][column] == 1) {
                        coordinatesToVisit.add(new int[]{row + 1, column});
                    }
                }
            }

            //go left
            if (column - 1 >= 0) {
                if (!visits[row][column - 1]) {
                    visits[row][column - 1] = true;
                    if (matrix[row][column - 1] == 1) {
                        coordinatesToVisit.add(new int[]{row, column - 1});
                    }
                }
            }
        }
        return riverSize;
    }
}
