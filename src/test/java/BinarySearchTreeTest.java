import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class BinarySearchTreeTest {
    static BinarySearchTree.BST test1;

    @Test
    public void testInsert() {
        test1 = new BinarySearchTree.BST(10);
        test1.insert(5).insert(15).insert(5).insert(2).insert(1).insert(22)
            .insert(13).insert(14);
        List<Integer> list = BinarySearchTree.BST.inOrderTraverse(test1, new ArrayList<>());
        BinarySearchTree.BST.validateBst(test1);
    }

}
