import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MultiStringSearchTest {

    @Test
    public void testMultiStringSearch() {
        String bigString = "This is a big string";
        String[] smallStrings = {"is", "a", "stringsvariable"};

        List<Boolean> expected = new ArrayList<>();
        expected.add(true);
        expected.add(true);
        expected.add(false);

        List<Boolean> result = MultiStringSearch.multiStringSearch(bigString, smallStrings);
        Assert.assertEquals(expected, result);
    }

}
