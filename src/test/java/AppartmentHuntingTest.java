import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AppartmentHuntingTest {

    @Test
    public void testAppartmentHunting() {
        List<Map<String, Boolean>> blocks = new ArrayList<>();
        Map<String, Boolean> block1 = new HashMap<>();
        block1.put("school", true);
        block1.put("gym", false);
        block1.put("store", false);
        Map<String, Boolean> block2 = new HashMap<>();
        block2.put("gym", true);
        block2.put("school", false);
        block2.put("store", false);
        Map<String, Boolean> block3 = new HashMap<>();
        block3.put("gym", true);
        block3.put("school", true);
        block3.put("store", false);
        Map<String, Boolean> block4 = new HashMap<>();
        block4.put("school", true);
        block4.put("gym", false);
        block4.put("store", false);
        Map<String, Boolean> block5 = new HashMap<>();
        block5.put("gym", false);
        block5.put("school", true);
        block5.put("store", true);

        blocks.add(block1);
        blocks.add(block2);
        blocks.add(block3);
        blocks.add(block4);
        blocks.add(block5);

        String[] requirements = {"gym", "school", "store"};

        int expected = 3;
        int result = AppartmentHunting.apartmentHunting(blocks, requirements);

        Assert.assertTrue(expected == result);
    }

}
