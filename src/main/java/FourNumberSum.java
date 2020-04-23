import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourNumberSum {
    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        List<Integer[]> quadruplets = new ArrayList<>();
        Map<Integer, List<Integer[]>> pairSums = new HashMap<>();

        for (int i = 1; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int currentSum = array[i] + array[j];
                int diff = targetSum - currentSum;

                if (pairSums.containsKey(diff)) {
                    for (Integer[] pair : pairSums.get(diff)) {
                        Integer[] quadruplet = {pair[0], pair[1], array[i], array[j]};
                        quadruplets.add(quadruplet);
                    }
                }
            }

            for (int k = 0; k < i; k++) {
                int currentSum = array[i] + array[k];
                Integer[] pair = {array[i], array[k]};

                if (!pairSums.containsKey(currentSum)) {
                    List<Integer[]> pairs = new ArrayList<>();
                    pairs.add(pair);
                    pairSums.put(currentSum, pairs);
                } else {
                    pairSums.get(currentSum).add(pair);
                }
            }
        }


        return quadruplets;
    }
}

