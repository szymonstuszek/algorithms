import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static List<List<Integer>> getPermutations(List<Integer> array) {
        List<List<Integer>> permutations = new ArrayList<>();
        getPermutations(0, array, permutations);
        return permutations;
    }

    private static void getPermutations(int i, List<Integer> array, List<List<Integer>> permutations) {

        if (i == array.size() - 1) {
            permutations.add(new ArrayList<>(array));
        } else {
            for (int j = i; j < array.size(); j++) {
                swap(i, j, array);
                getPermutations(i + 1, array, permutations);
                swap(i, j, array);
            }
        }
    }

    public static void swap(int i, int j, List<Integer> array) {
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }
}
