import org.junit.Test;

public class SearchForRangeTest {

    @Test
    public void testSearchForRange() {
        int[] array = {0, 1, 21, 33, 45, 45, 45, 45, 45, 45, 61, 71, 73};
        int target = 45;

        int[] expected = {4, 9};
        int[] result = SearchForRange.searchForRange(array, target);
    }

}
