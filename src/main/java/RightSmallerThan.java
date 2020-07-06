import java.util.ArrayList;
import java.util.List;

public class RightSmallerThan {

    public static List<Integer> rightSmallerThan(List<Integer> array) {
        if(array.size() == 0) {
            return new ArrayList<>();
        }
        List<Integer> rightSmallerCounts = new ArrayList<>(array);
        int lastIdx = array.size() - 1;
        SpecialBst bst = new SpecialBst(array.get(lastIdx));
        rightSmallerCounts.set(lastIdx, 0);
        for (int i = array.size() - 2; i >= 0; i--) {
            bst.insert(array.get(i), i, rightSmallerCounts);
        }
        return rightSmallerCounts;
    }

    private static class SpecialBst {
        private int value;
        private int leftSubtreeSize;
        private SpecialBst left;
        private SpecialBst right;

        public SpecialBst(int value) {
            this.value = value;
            this.leftSubtreeSize = 0;
            this.left = null;
            this.right = null;
        }

        public void insert(int value, int idx, List<Integer> rightSmallerCounts) {
            insertHelper(value, idx, rightSmallerCounts, 0);
        }

        public void insertHelper(int value, int idx, List<Integer> rightSmallerCounts, int numSmallerAtInsertTime) {
            if(value < this.value) {
                leftSubtreeSize++;
                if (left == null) {
                    left = new SpecialBst(value);
                    rightSmallerCounts.set(idx, numSmallerAtInsertTime);
                } else {
                    left.insertHelper(value, idx, rightSmallerCounts, numSmallerAtInsertTime);
                }
            } else {
                numSmallerAtInsertTime += leftSubtreeSize;
                if (value > this.value) {
                    numSmallerAtInsertTime++;
                }
                if (right == null) {
                    right = new SpecialBst(value);
                    rightSmallerCounts.set(idx, numSmallerAtInsertTime);
                } else {
                    right.insertHelper(value, idx, rightSmallerCounts, numSmallerAtInsertTime);
                }
            }
        }
    }


}
