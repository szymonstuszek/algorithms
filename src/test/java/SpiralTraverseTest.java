import org.junit.Test;

import static org.junit.Assert.*;

public class SpiralTraverseTest {


    @Test
    public void testTraverse() {

        int[][] array = {
                {1,2,3,4},
                {12,13,14,5},
                {11,16,15,6},
                {10,9,8,7}
        };

        SpiralTraverse.spiralTraverse(array);
    }

    @Test
    public void testTraverse2() {

        int[][] array = {
                {1, 2, 3, 4},
                {22, 23, 24, 5},
                {21, 36, 25, 6},
                {20, 35, 26, 7},
                {19, 34, 27, 8},
                {18, 33, 28, 9},
                {17, 32, 29, 10},
                {16, 31, 30, 11},
                {15, 14, 13, 12},
        };

        SpiralTraverse.spiralTraverse(array);
    }

}
