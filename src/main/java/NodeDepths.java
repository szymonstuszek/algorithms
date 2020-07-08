

public class NodeDepths {

    public static int nodeDepths(BinaryTree root) {
        return countNodeDepths(root, 0);
    }

    public static int countNodeDepths(BinaryTree root, int depth) {
        if (root == null) {
            return 0;
        }
        return depth + countNodeDepths(root.left, depth + 1) + countNodeDepths(root.right, depth + 1);
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
