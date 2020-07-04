import java.util.ArrayList;
import java.util.List;

public class NumberOfBinaryTreeTopologies {

    public static int numberOfBinaryTreeTopologies(int n) {

        List<Integer> cache = new ArrayList<>();
        cache.add(1);

        for (int m = 1; m < n + 1; m++) {
            int numberOfTrees = 0;

            for (int leftTreeSize = 0; leftTreeSize < m; leftTreeSize++) {
                int rightTreeSize = m - 1 - leftTreeSize;
                int numberOfLeftTrees = cache.get(leftTreeSize);
                int numberOfRightTrees = cache.get(rightTreeSize);
                numberOfTrees += numberOfLeftTrees * numberOfRightTrees;
            }

            cache.add(numberOfTrees);
        }

        return cache.get(n);
    }
}
