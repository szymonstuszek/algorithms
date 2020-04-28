import org.junit.Test;

import static org.junit.Assert.*;

public class MaxPathSumTest {

    public static MaxPathSum.BinaryTree createTestTreeOf7Elements() {
        MaxPathSum.BinaryTree tree = new MaxPathSum.BinaryTree(1);
        tree.left = new MaxPathSum.BinaryTree(2);
        tree.right = new MaxPathSum.BinaryTree(3);

        tree.left.left = new MaxPathSum.BinaryTree(4);
        tree.left.right = new MaxPathSum.BinaryTree(5);

        tree.right.left = new MaxPathSum.BinaryTree(6);
        tree.right.right = new MaxPathSum.BinaryTree(7);
        return tree;
    }

    public static MaxPathSum.BinaryTree createTestTreeOf3Elements() {
        MaxPathSum.BinaryTree tree = new MaxPathSum.BinaryTree(1);
        tree.left = new MaxPathSum.BinaryTree(2);
        tree.right = new MaxPathSum.BinaryTree(3);

        return tree;
    }

    public static MaxPathSum.BinaryTree createTestTreeOf1Elements() {
        MaxPathSum.BinaryTree tree = new MaxPathSum.BinaryTree(1);
        return tree;
    }

    @Test
    public void testTreeOf7Elements() {
        MaxPathSum.BinaryTree tree = createTestTreeOf7Elements();
        assertEquals(18, MaxPathSum.maxPathSum(tree));
    }

}
