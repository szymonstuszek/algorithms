import org.junit.Test;

import static org.junit.Assert.*;

public class SortedMatrixSearchTest {

    private int[][] array = {
            {1, 2, 3,},
            {4, 5, 6},
            {6, 8, 9}
    };


    @Test
    public void testSearch() {

        SortedMatrixSearch.searchInSortedMatrix(array, 7);

    }


}
