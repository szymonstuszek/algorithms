import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LongestCommonSubsequenceTest {

    @Test
    public void testLongestCommonSubsequence() {
        String str1 = "ZXVVYZW";
        String str2 = "XKYKZPW";

        List<Character> expected = new ArrayList(Arrays.asList('X', 'Y', 'Z', 'W'));
        List<Character> result = LongestCommonSubsequence.longestCommonSubsequence(str1, str2);

        assertEquals(expected, result);
    }

    @Test
    public void testLongestCommonSubsequence2() {
        String str1 = "ABC";
        String str2 = "AB";

        List<Character> expected = new ArrayList(Arrays.asList('A', 'B'));
        List<Character> result = LongestCommonSubsequence.longestCommonSubsequence(str1, str2);

        assertEquals(expected, result);
    }

    @Test
    public void testLongestCommonSubsequence3() {
        String str1 = "ABCD";
        String str2 = "CD";

        List<Character> expected = new ArrayList(Arrays.asList('C', 'D'));
        List<Character> result = LongestCommonSubsequence.longestCommonSubsequence(str1, str2);

        assertEquals(expected, result);
    }

    @Test
    public void testLongestCommonSubsequence4() {
        String str1 = "ABCD";
        String str2 = "JBCY";

        List<Character> expected = new ArrayList(Arrays.asList('B', 'C'));
        List<Character> result = LongestCommonSubsequence.longestCommonSubsequence(str1, str2);

        assertEquals(expected, result);
    }

    @Test
    public void testLongestCommonSubsequence5() {
        String str1 = "CHD";
        String str2 = "BHD";

        List<Character> expected = new ArrayList(Arrays.asList('H', 'D'));
        List<Character> result = LongestCommonSubsequence.longestCommonSubsequence(str1, str2);

        assertEquals(expected, result);
    }

}
