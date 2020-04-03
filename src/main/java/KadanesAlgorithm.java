//Write a function that takes an non-empty array of integers and returns the max sum
//that can be obtained from summimg up all of the integers in a non-empty subarray of the input array.
//The subarray may contain only adjacent numbers.
public class KadanesAlgorithm {
    public static int kadanesAlgorithm(int[] array) {
        int[] sums = new int[array.length];
        sums[0] = array[0];
        int highestSum = sums[0];

        for (int i = 1; i < sums.length; i++) {

            if (array[i] > array[i] + sums[i - 1]) {
                sums[i] = array[i];
            } else {
                sums[i] = array[i] + sums[i - 1];
            }

            if (sums[i] > highestSum) {
                highestSum = sums[i];
            }
        }

        return -1;
    }
}
