import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LongestStringChainTest {

    @Test
    public void testLongestStringChain() {
        List<String> input = new ArrayList<>(Arrays.asList("abde", "abc", "abd", "abcde", "ade", "ae", "1abde", "abcdef"));
        List<String> expected = new ArrayList<>();
        expected.add("abcdef");
        expected.add("abcde");
        expected.add("abde");
        expected.add("ade");
        expected.add("ae");

        List<String> result = LongestStringChain.longestStringChain(input);
        Assert.assertEquals(expected, result);
    }

}
