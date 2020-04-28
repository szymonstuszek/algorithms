import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxPathSum {
    public static int maxPathSum(BinaryTree tree) {
        List<Integer> maxSums = findMaxPathSum(tree);
        return maxSums.get(1);
    }

    private static ArrayList<Integer> findMaxPathSum(BinaryTree tree) {
        if (tree == null) {
            return new ArrayList<>(Arrays.asList(0, 0));
        }

        List<Integer> leftMaxPathSums = findMaxPathSum(tree.left);
        Integer leftBranchSum = leftMaxPathSums.get(0);
        Integer leftMaxPathSum = leftMaxPathSums.get(1);


        List<Integer> rightMaxPathSums = findMaxPathSum(tree.right);
        Integer rightBranchSum = rightMaxPathSums.get(0);
        Integer rightMaxPathSum = rightMaxPathSums.get(1);

        Integer maxChildSum = Math.max(leftBranchSum, rightBranchSum);
        Integer maxBranchSum = Math.max(maxChildSum + tree.value, tree.value);
        Integer maxRootNodeSum = Math.max(maxBranchSum, leftBranchSum + tree.value + rightBranchSum);
        Integer maxPathSum = Math.max(leftMaxPathSum, Math.max(maxRootNodeSum, rightMaxPathSum));

        return new ArrayList<>(Arrays.asList(maxBranchSum, maxPathSum));
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
