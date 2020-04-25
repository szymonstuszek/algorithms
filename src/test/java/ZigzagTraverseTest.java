import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class ZigzagTraverseTest {


    @Test
    public void testOneElementArray() {
        List<List<Integer>> rows = new ArrayList<>();
        List<Integer> columns = new ArrayList<>();
        columns.add(1);
        rows.add(columns);

        List<Integer> expected = new ArrayList<>();
        expected.add(1);

        List<Integer> result = ZigzagTraverse.zigzagTraverse(rows);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void test4x4ElementArray() {
        List<List<Integer>> rows = new ArrayList<>();
        List<Integer> column1 = new ArrayList<>();
        column1.add(1);
        column1.add(3);
        List<Integer> column2 = new ArrayList<>();
        column2.add(2);
        column2.add(4);
        rows.add(column1);
        rows.add(column2);

        List<Integer> expected = IntStream.rangeClosed(1, 4).boxed().collect(Collectors.toList());
        List<Integer> result = ZigzagTraverse.zigzagTraverse(rows);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void compareTwoListsWithDifferentOrderNotEqual() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);

        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(1);

        Assert.assertNotEquals(list1, list2);

    }

    @Test
    public void compareTwoListsWithSameOrderEqual() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);

        Assert.assertEquals(list1, list2);

    }

}
