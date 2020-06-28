

public class AllKindsOfNodeDepths {

    public static int allKindsOfNodeDepths(BinaryTree root) {
        return getTreeInfo(root).sumOfAllDepths;
    }

    public static TreeInfo getTreeInfo(BinaryTree tree) {
        if (tree == null) {
            return new TreeInfo(0, 0, 0);
        }

        TreeInfo leftTreeInfo = getTreeInfo(tree.left);
        TreeInfo rightTreeInfo = getTreeInfo(tree.right);

        int sumOfLeftDepths = leftTreeInfo.sumOfDepths + leftTreeInfo.numberOfNodesInTree;
        int sumOfRightDepths = rightTreeInfo.sumOfDepths + rightTreeInfo.numberOfNodesInTree;

        int numberOfNodesInTree = 1 + leftTreeInfo.numberOfNodesInTree + rightTreeInfo.numberOfNodesInTree;
        int sumOfDepths = sumOfLeftDepths + sumOfRightDepths;
        int sumOfAllDepths = sumOfDepths + leftTreeInfo.sumOfAllDepths + rightTreeInfo.sumOfAllDepths;

        return new TreeInfo(numberOfNodesInTree, sumOfDepths, sumOfAllDepths);
    }

    static class TreeInfo {
        public int numberOfNodesInTree;
        public int sumOfDepths;
        public int sumOfAllDepths;

        public TreeInfo(int numberOfNodesInTree, int sumOfDepths, int sumOfAllDepths) {
            this.numberOfNodesInTree = numberOfNodesInTree;
            this.sumOfDepths = sumOfDepths;
            this.sumOfAllDepths = sumOfAllDepths;
        }
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}
