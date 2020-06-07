import org.junit.Assert;
import org.junit.Test;

public class InterweavingStringsTest {

    @Test
    public void testInterweavingStrings() {
        String one = "a";
        String two = "b";
        String three = "ab";

        Assert.assertTrue(InterweavingStrings.interweavingStrings(one, two, three));
    }

    @Test
    public void testInterweavingStrings2() {
        String one = "a";
        String two = "b";
        String three = "ba";

        Assert.assertTrue(InterweavingStrings.interweavingStrings(one, two, three));
    }

    @Test
    public void testInterweavingStrings3() {
        String one = "a";
        String two = "b";
        String three = "ac";

        Assert.assertFalse(InterweavingStrings.interweavingStrings(one, two, three));
    }

    @Test
    public void testInterweavingStrings4() {
        String one = "aa";
        String two = "ab";
        String three = "aaba";

        Assert.assertTrue(InterweavingStrings.interweavingStrings(one, two, three));
    }

    @Test
    public void testInterweavingStrings5() {
        String one = "aa";
        String two = "aab";
        String three = "aabaa";

        Assert.assertTrue(InterweavingStrings.interweavingStrings(one, two, three));
    }

    @Test
    public void testInterweavingStrings6() {
        String one = "aaa";
        String two = "aab";
        String three = "aabaaa";

        Assert.assertTrue(InterweavingStrings.interweavingStrings(one, two, three));
    }
}
