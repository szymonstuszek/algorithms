import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TopologicalSortTest {

    @Test
    public void testTopologicalSort() {
        List<Integer> jobs = new ArrayList<>();
        jobs.add(1);
        jobs.add(2);
        jobs.add(3);
        jobs.add(4);

        List<Integer[]> dependencies = new ArrayList<>();
        Integer[] dep1 = new Integer[]{1,2};
        Integer[] dep2 = new Integer[]{1,3};
        Integer[] dep3 = new Integer[]{3,2};
        Integer[] dep4 = new Integer[]{4,2};
        Integer[] dep5 = new Integer[]{4,3};
        dependencies.add(dep1);
        dependencies.add(dep2);
        dependencies.add(dep3);
        dependencies.add(dep4);
        dependencies.add(dep5);

        List<Integer> expected = new ArrayList<>();
        expected.add(4);
        expected.add(1);
        expected.add(3);
        expected.add(2);

        List<Integer> result = TopologicalSort.topologicalSort(jobs, dependencies);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testTopologicalSortCyclicCase() {
        List<Integer> jobs = new ArrayList<>();
        jobs.add(1);
        jobs.add(2);
        jobs.add(3);
        jobs.add(4);
        jobs.add(5);
        jobs.add(6);
        jobs.add(7);
        jobs.add(8);

        List<Integer[]> dependencies = new ArrayList<>();
        Integer[] dep1 = new Integer[]{3,1};
        Integer[] dep2 = new Integer[]{8,1};
        Integer[] dep3 = new Integer[]{8,7};
        Integer[] dep4 = new Integer[]{5,7};
        Integer[] dep5 = new Integer[]{5,2};
        Integer[] dep6 = new Integer[]{1,4};
        Integer[] dep7 = new Integer[]{6,7};
        Integer[] dep8 = new Integer[]{1,2};
        Integer[] dep9 = new Integer[]{7,6};
        dependencies.add(dep1);
        dependencies.add(dep2);
        dependencies.add(dep3);
        dependencies.add(dep4);
        dependencies.add(dep5);
        dependencies.add(dep6);
        dependencies.add(dep7);
        dependencies.add(dep8);
        dependencies.add(dep9);

        List<Integer> expected = new ArrayList<>();

        List<Integer> result = TopologicalSort.topologicalSort(jobs, dependencies);
        Assert.assertEquals(expected, result);
    }
}
