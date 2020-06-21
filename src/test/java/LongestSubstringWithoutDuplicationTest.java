import org.junit.Assert;
import org.junit.Test;


public class LongestSubstringWithoutDuplicationTest {

    @Test
    public void testLongestSubstringWithoutDuplication() {
        String str = "clementisacap";
        String expected = "mentisac";

        String result = LongestSubstringWithoutDuplication.longestSubstringWithoutDuplication(str);
        Assert.assertEquals(expected, result);
    }

}
