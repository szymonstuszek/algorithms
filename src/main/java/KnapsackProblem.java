import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KnapsackProblem {

    public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
        int[][] values = new int[items.length + 1][capacity + 1];

        for (int row = 1; row < items.length + 1; row++) {

            int currentValue = items[row - 1][0];
            int currentWeight = items[row - 1][1];

            for (int column = 0; column < capacity + 1; column++) {

                if (currentWeight <= column) {

                    int bestValue = Math.max(
                            values[row - 1][column],
                            values[row - 1][column - currentWeight] + currentValue
                    );

                    values[row][column] = bestValue;

                } else {
                    values[row][column] = values[row - 1][column];
                }
            }
        }

        return getItems(items, values, capacity);
    }

    public static List<List<Integer>> getItems(int[][] items, int[][] values, int capacity) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> finalItems = new ArrayList<>();

        result.add(new ArrayList<>());
        result.add(finalItems);

        int i = values.length - 1;
        int j = values[0].length - 1;
        int finalValue = 0;

        while (values[i][j] != 0) {

            if (values[i][j] == values[i - 1][j]) {
                i--;
            } else {
                int itemIndex = i - 1;
                finalItems.add(0, itemIndex);
                finalValue += items[i - 1][0];
                j -= items[i - 1][1];
                i--;
            }
        }

        result.get(0).add(finalValue);
        return result;
    }
}
