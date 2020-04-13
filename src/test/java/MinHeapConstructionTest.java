import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MinHeapConstructionTest {

    MinHeapConstruction.MinHeap test1 =
            new MinHeapConstruction.MinHeap(new ArrayList<Integer>(Arrays.asList(2, 3, 1)));

    @Test
    public void testSwap() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        MinHeapConstruction.MinHeap.swap(1,2, list);
    }

    @Test
    public void testInsert() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        test1.insert(1);

    }

}
