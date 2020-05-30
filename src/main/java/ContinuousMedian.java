import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class ContinuousMedian {

    static class ContinuousMedianHandler {
        private Heap lower = new Heap(Heap::MAX_HEAP, new ArrayList<>());
        private Heap higher = new Heap(Heap::MIN_HEAP, new ArrayList<>());
        double median = 0;

        public void insert(int number) {

            if (lower.length == 0 || number < lower.peek()) {
                lower.insert(number);
            } else {
                higher.insert(number);
            }
            rebalanceHeaps();
            updateMedian();
        }

        public void rebalanceHeaps() {
            if (lower.length - higher.length == 2) {
                int valueToMove = lower.remove();
                higher.insert(valueToMove);
            } else if (higher.length - lower.length == 2) {
                int valueToMove = higher.remove();
                lower.insert(valueToMove);
            }
        }

        public void updateMedian() {
            if (lower.length == higher.length) {
                median = ((double) lower.peek() + higher.peek()) / 2;
            } else if (higher.length > lower.length) {
                median = higher.peek();
            } else {
                median = lower.peek();
            }
        }

        public double getMedian() {
            return median;
        }
    }

    static class Heap {
        List<Integer> heap = new ArrayList<>();
        BiFunction<Integer, Integer, Boolean> comparisonFunction;
        int length;

        public Heap(BiFunction<Integer, Integer, Boolean> comparisonFunction, List<Integer> array) {
            heap = buildHeap(array);
            this.comparisonFunction = comparisonFunction;
            length = heap.size();
        }

        private List<Integer> buildHeap(List<Integer> array) {
            int firstParentIdx = (array.size() - 2) / 2;
            for (int currentIdx = firstParentIdx; currentIdx >= 0; currentIdx--) {
                siftDown(currentIdx, array.size() - 1, array);
            }
            return array;
        }

        public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
            int childOneIdx = currentIdx * 2 + 1;
            while (childOneIdx <= endIdx) {
                int childTwoIdx = currentIdx * 2 + 2 <= endIdx ? currentIdx * 2 + 2 : -1;
                int idxToSwap;

                if (childTwoIdx != -1) {
                    if (comparisonFunction.apply(heap.get(childTwoIdx), heap.get(childOneIdx))) {
                        idxToSwap = childTwoIdx;
                    } else {
                        idxToSwap = childOneIdx;
                    }
                } else {
                    idxToSwap = childOneIdx;
                }

                if (comparisonFunction.apply(heap.get(idxToSwap), heap.get(currentIdx))) {
                    swap(currentIdx, idxToSwap, heap);
                    currentIdx = idxToSwap;
                    childOneIdx = currentIdx * 2 + 1;
                } else {
                    return;
                }
            }

        }

        public void siftUp(int currentIdx, List<Integer> heap) {
            int parentIdx = (currentIdx - 1) / 2;
            while (currentIdx > 0) {
                if (comparisonFunction.apply(heap.get(currentIdx), heap.get(parentIdx))) {
                    swap(currentIdx, parentIdx, heap);
                    currentIdx = parentIdx;
                    parentIdx = (currentIdx - 1) / 2;
                } else {
                    return;
                }
            }
        }

        public int peek() {
            return heap.get(0);
        }

        public void insert(int value) {
            heap.add(value);
            length++;
            siftUp(heap.size() - 1, heap);
        }

        public int remove() {
            swap(0, heap.size() - 1, heap);
            int valueToRemove = heap.get(heap.size() - 1);
            heap.remove(heap.size() - 1);
            length--;
            siftDown(0, heap.size() - 1, heap);
            return valueToRemove;
        }

        public void swap(int i, int j, List<Integer> heap) {
            Integer temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
        }

        public static Boolean MAX_HEAP(Integer a, Integer b) {
            return a > b;
        }

        public static Boolean MIN_HEAP(Integer a, Integer b) {
            return a < b;
        }
    }
}
