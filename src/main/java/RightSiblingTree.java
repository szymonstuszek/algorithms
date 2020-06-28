

public class RightSiblingTree {

    public static BinaryTree rightSiblingTree(BinaryTree root) {
        mutate(root, null, false);
        return root;
    }

    private static void mutate(BinaryTree node, BinaryTree parent, boolean isLeft) {
        if (node == null) {
            return;
        }

        BinaryTree left = node.left;
        BinaryTree right = node.right;
        mutate(left, node, true);
        if (parent == null) {
            node.right = null;
        } else if (isLeft) {
            node.right = parent.right;
        } else {
            if (parent.right == null) {
                node.right = null;
            } else {
                node.right = parent.right.left;
            }
        }
        mutate(right, node, false);
    }

    // This is the class of the input root. Do not edit it.
    static class BinaryTree {
        int value;
        BinaryTree left = null;
        BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
