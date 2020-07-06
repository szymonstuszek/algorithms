import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class RightSmallerThanTest {

    @Test
    public void testRightSmallerThan() {
        List<Integer> input = new ArrayList<>();
        input.add(8);
        input.add(5);
        input.add(11);
        input.add(-1);
        input.add(3);
        input.add(4);
        input.add(2);

        List<Integer> expected = new ArrayList<>();
        expected.add(5);
        expected.add(4);
        expected.add(4);
        expected.add(0);
        expected.add(1);
        expected.add(1);
        expected.add(0);

        List<Integer> result = RightSmallerThan.rightSmallerThan(input);
        Assert.assertEquals(input, expected);
    }
}
