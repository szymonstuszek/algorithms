import java.util.ArrayList;
import java.util.List;

public class ZigzagTraverse {
    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
        List<Integer> zigzag = new ArrayList<>();
        int rows = array.size();
        int columns = array.get(0).size();
        int leftColumn = 0;
        int topRow = 0;
        int rightColumn = columns - 1;
        int bottomRow = rows - 1;

        boolean goingDown = true;
        boolean traversing = true;

        int currentRow = 0;
        int currentColumn = 0;

        int currentValue = array.get(currentRow).get(currentColumn);
        zigzag.add(currentValue);

        while (traversing) {
            if (goingDown) {
                while(goingDown) {
                    if (currentColumn == leftColumn && currentRow == bottomRow) {
                        currentColumn++;
                        isInBounds(currentRow, currentColumn, array, zigzag);
                        goingDown = false;
                    } else if (currentColumn == leftColumn) {
                        currentRow++;
                        isInBounds(currentRow, currentColumn, array, zigzag);
                        goingDown = false;

                    } else {
                        currentColumn--;
                        currentRow++;
                        isInBounds(currentRow, currentColumn, array, zigzag);
                    }
                }

            } else {
                while(!goingDown) {
                    if (currentColumn == rightColumn) {
                        currentRow++;
                        isInBounds(currentRow, currentColumn, array, zigzag);
                        goingDown = true;
                    } else if (currentRow == topRow) {
                        currentColumn++;
                        isInBounds(currentRow, currentColumn, array, zigzag);
                        goingDown = true;

                    } else {
                        currentColumn++;
                        currentRow--;
                        isInBounds(currentRow, currentColumn, array, zigzag);
                    }
                }
            }
            if (currentColumn >= rightColumn && currentRow >= bottomRow) {
                traversing = false;
            }
        }
        return zigzag;
    }

    private static void isInBounds(int currentRow, int currentColumn, List<List<Integer>> array, List<Integer> zigzag) {
        if(currentRow >= 0 && currentColumn >= 0 && currentRow < array.size() && currentColumn < array.get(0).size()) {
            int currentValue = array.get(currentRow).get(currentColumn);
            zigzag.add(currentValue);
        }
    }
}
