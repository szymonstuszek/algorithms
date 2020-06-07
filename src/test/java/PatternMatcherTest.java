import org.junit.Assert;
import org.junit.Test;

public class PatternMatcherTest {

    @Test
    public void testPatternMatcher() {
        String pattern = "xxyxxy";
        String str = "gogopowerrangergogopowerranger";

        String[] expected = {"go", "powerranger"};
        String[] result = PatternMatcher.patternMatcher(pattern, str);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void testPatternMatcher2() {
        String pattern = "xyxy";
        String str = "abab";

        String[] expected = {"a", "b"};
        String[] result = PatternMatcher.patternMatcher(pattern, str);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void testPatternMatcher3() {
        String pattern = "yxyx";
        String str = "abab";

        String[] expected = {"b", "a"};
        String[] result = PatternMatcher.patternMatcher(pattern, str);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void testPatternMatcher4() {
        String pattern = "yyxyyx";
        String str = "gogopowerrangergogopowerranger";

        String[] expected = {"powerranger", "go"};
        String[] result = PatternMatcher.patternMatcher(pattern, str);

        Assert.assertEquals(expected, result);
    }

}
