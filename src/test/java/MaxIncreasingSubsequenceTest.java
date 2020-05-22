import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MaxIncreasingSubsequenceTest {

    @Test
    public void testMaxIncreasingSubsequence() {
        int[] input = {10, 70, 20, 30, 50, 11, 30};
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(Arrays.asList(110)));
        List<Integer> expectedSequence = new ArrayList<>(Arrays.asList(10, 20, 30, 50));
        expected.add(expectedSequence);

        List<List<Integer>> result = MaxIncreasingSubsequence.maxSumIncreasingSubsequence(input);

        assertEquals(expected, result);

    }

    @Test
    public void testMaxIncreasingSubsequenceOneElement() {
        int[] input = {1};
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(Arrays.asList(1)));
        List<Integer> expectedSequence = new ArrayList<>(Arrays.asList(1));
        expected.add(expectedSequence);

        List<List<Integer>> result = MaxIncreasingSubsequence.maxSumIncreasingSubsequence(input);

        assertEquals(expected, result);

    }

    @Test
    public void testMaxIncreasingSubsequenceNegativeElements() {
        int[] input = {-1, 1};
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(Arrays.asList(1)));
        List<Integer> expectedSequence = new ArrayList<>(Arrays.asList(1));
        expected.add(expectedSequence);

        List<List<Integer>> result = MaxIncreasingSubsequence.maxSumIncreasingSubsequence(input);

        assertEquals(expected, result);

    }

    @Test
    public void testMaxIncreasingSubsequenceExampleArray() {
        int[] input = {8, 12, 2, 3, 15, 5, 7};
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(Arrays.asList(35)));
        List<Integer> expectedSequence = new ArrayList<>(Arrays.asList(8, 12, 15));
        expected.add(expectedSequence);

        List<List<Integer>> result = MaxIncreasingSubsequence.maxSumIncreasingSubsequence(input);

        assertEquals(expected, result);

    }

    @Test
    public void testMaxIncreasingSubsequenceExampleArray2() {
        int[] input = {10, 70, 20, 30, 50, 11, 30};
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(Arrays.asList(110)));
        List<Integer> expectedSequence = new ArrayList<>(Arrays.asList(10, 20, 30, 50));
        expected.add(expectedSequence);

        List<List<Integer>> result = MaxIncreasingSubsequence.maxSumIncreasingSubsequence(input);

        assertEquals(expected, result);

    }

    @Test
    public void testMaxIncreasingSubsequenceExampleArray3() {
        int[] input = {1, 2, 3, 4, 5};
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(Arrays.asList(15)));
        List<Integer> expectedSequence = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        expected.add(expectedSequence);

        List<List<Integer>> result = MaxIncreasingSubsequence.maxSumIncreasingSubsequence(input);

        assertEquals(expected, result);

    }

}
