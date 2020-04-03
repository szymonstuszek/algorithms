import org.junit.Test;

import static org.junit.Assert.*;

public class MonotonicArrayTest {

    @Test
    public void testMonotonicArray() {

        int[] array = {-1, -5, -10, -1100, -1100, -1101, -1102, -9001};

        MonotonicArray.isMonotonic(array);

    }

}
