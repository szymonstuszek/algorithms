import org.junit.Assert;
import org.junit.Test;

public class SmallestSubstringContainingTest {


    @Test
    public void testSmallestSubstringContaining() {
        String bigString = "abcd$ef$axb$c$";
        String smallString = "$$abf";

        String expected = "f$axb$";
        String result = SmallestSubstringContaining.smallestSubstringContaining(bigString, smallString);
        Assert.assertTrue(expected.equals(result));
    }
}
