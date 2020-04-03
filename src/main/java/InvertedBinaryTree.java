public class InvertedBinaryTree {
    public static void invertBinaryTree(BinaryTree tree) {

        if (tree.left == null && tree.right == null) {
            return;
        }

        swapNodes(tree);

        if (tree.left != null) {
            invertBinaryTree(tree.left);
        }

        if (tree.right != null) {
            invertBinaryTree(tree.right);
        }
    }

    private static void swapNodes(BinaryTree tree) {
        BinaryTree tempTree = tree.left;
        tree.left = tree.right;
        tree.right = tempTree;
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
