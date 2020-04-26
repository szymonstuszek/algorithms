import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SameBstsTest {

    @Test
    public void testSameBstJustRoot() {

        List<Integer> arrayOne = new ArrayList<>();
        arrayOne.add(5);
        List<Integer> arrayTwo = new ArrayList<>();
        arrayTwo.add(5);

        assertTrue(SameBsts.sameBsts(arrayOne, arrayTwo));
    }

    @Test
    public void testSameBsts3ElementTrees() {

        List<Integer> arrayOne = new ArrayList<>();
        arrayOne.add(5);
        arrayOne.add(10);
        arrayOne.add(2);
        List<Integer> arrayTwo = new ArrayList<>();
        arrayTwo.add(5);
        arrayTwo.add(10);
        arrayTwo.add(2);

        assertTrue(SameBsts.sameBsts(arrayOne, arrayTwo));
    }

    @Test
    public void testDifferentBsts3ElementTrees() {

        List<Integer> arrayOne = new ArrayList<>();
        arrayOne.add(5);
        arrayOne.add(10);
        arrayOne.add(2);
        List<Integer> arrayTwo = new ArrayList<>();
        arrayTwo.add(5);
        arrayTwo.add(10);
        arrayTwo.add(3);

        assertTrue(SameBsts.sameBsts(arrayOne, arrayTwo));
    }

}
