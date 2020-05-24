import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class KnapsackProblemTest {

    @Test
    public void testKnapsack() {
        int[][] items = {{1, 2}, {4, 3}, {5, 6}, {6, 7}};
        int capacity = 10;

        List<List<Integer>> expected = new ArrayList<>();
        int maxValue = 10;
        List<Integer> finalItems = new ArrayList<>();
        finalItems.add(1);
        finalItems.add(3);
        expected.add(new ArrayList<>());
        expected.get(0).add(maxValue);
        expected.add(finalItems);

        List<List<Integer>> result = KnapsackProblem.knapsackProblem(items, capacity);

        Assert.assertTrue(expected.size() == result.size() &&
                expected.containsAll(result) &&
                result.containsAll(expected));
    }

}
