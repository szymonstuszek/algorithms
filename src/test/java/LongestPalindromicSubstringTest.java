import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LongestPalindromicSubstringTest {

    @Test
    public void testPalindrom() {
        Assert.assertTrue(LongestPalindromicSubstring.longestPalindromicSubstring("it's highnoon").equals("noon"));
    }

    @Test
    public void testPalindrom2() {
        Assert.assertTrue(LongestPalindromicSubstring.longestPalindromicSubstring("noon high it is").equals("noon"));
    }

    @Test
    public void testPalindrom3() {
        Assert.assertTrue(LongestPalindromicSubstring.longestPalindromicSubstring("abaxyzzyxf").equals("xyzzyx"));
    }

    @Test
    public void TestCase11() {
        Assert.assertTrue(LongestPalindromicSubstring.longestPalindromicSubstring("z234a5abbbba54a32z").equals("5abbbba5"));
    }
}
