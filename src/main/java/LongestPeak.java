

public class LongestPeak {

    public static int longestPeak(int[] array) {
        int longestPeak = 0;

        for (int i = 1; i < array.length - 1; i++) {
            if (array[i - 1] < array[i] && array[i] > array[i + 1]) {

                int leftPeakLength = 0;
                int rightPeakLength = 0;
                int idx = 1;
                int idxr = 1;

                while (i - idx > 0) {
                    if (array[i - 1 - idx] < array[i - idx]) {
                        leftPeakLength++;
                        idx++;
                    } else {
                        break;
                    }
                }

                while (i + 1 + idxr < array.length) {
                    if (array[i + idxr] > array[i + idxr + 1]) {
                        rightPeakLength++;
                        idxr++;
                    } else {
                        break;
                    }
                }

                if (3 + leftPeakLength + rightPeakLength > longestPeak) {
                    longestPeak = 3 + leftPeakLength + rightPeakLength;
                }
            }

        }

        return longestPeak;
    }

}
