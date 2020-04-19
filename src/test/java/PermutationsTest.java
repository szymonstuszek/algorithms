import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PermutationsTest {

    @Test
    public void testPermutations() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<List<Integer>> permutations = Permutations.getPermutations(input);
    }

}
