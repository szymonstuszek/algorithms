import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DiscStackingTest {

   @Test
   public void testDiskStacking() {
    List<Integer[]> disks = new ArrayList<>();
    disks.add(new Integer[]{2, 1, 2});
    disks.add(new Integer[]{3, 2, 3});
    disks.add(new Integer[]{2, 2, 8});
    disks.add(new Integer[]{2, 3, 4});
    disks.add(new Integer[]{2, 2, 1});
    disks.add(new Integer[]{4, 4, 5});

    List<Integer[]> expected = new ArrayList<>();
    expected.add(new Integer[]{2, 1, 2});
    expected.add(new Integer[]{3, 2, 3});
    expected.add(new Integer[]{4, 4, 5});

    List<Integer[]> result = DiscStacking.diskStacking(disks);

    Assert.assertTrue(expected.equals(result));
   }
}
