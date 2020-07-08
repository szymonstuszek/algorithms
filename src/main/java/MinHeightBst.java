import java.util.List;

public class MinHeightBst {

    public static BST minHeightBst(List<Integer> array) {
        return constructMinHeightbst(array, 0, array.size() - 1);
    }

    private static BST constructMinHeightbst(List<Integer> array, int startIdx, int endIdx) {
        if (endIdx < startIdx) {
            return null;
        }
        int midIdx = (startIdx + endIdx) / 2;
        BST bst = new BST(array.get(midIdx));
        bst.left = constructMinHeightbst(array, startIdx, midIdx - 1);
        bst.right = constructMinHeightbst(array, midIdx + 1, endIdx);
        return bst;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }

}
