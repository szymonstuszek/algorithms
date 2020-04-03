import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {

    public static List<Integer> spiralTraverse(int[][] array) {
        List<Integer> result = new ArrayList<>();

        int startingRow = 0;
        int startingColumn = 0;
        int endingRow = array.length - 1;
        int endingColumn = array[0].length - 1;

        while (startingColumn < endingColumn && startingRow < endingRow) {

            for (int i = startingColumn; i <= endingColumn; i++) {
                result.add(array[startingRow][i]);
            }
            for (int i = startingRow; i < endingRow; i++) {
                result.add(array[i + 1][endingColumn]);
            }
            for (int i = endingColumn; i > startingColumn; i--) {
                result.add(array[endingRow][i - 1]);
            }
            for (int i = endingRow; i > startingRow + 1; i--) {
                result.add(array[i - 1][startingColumn]);
            }

            startingColumn++;
            endingColumn--;
            startingRow++;
            endingRow--;
        }

        return result;
    }
}
