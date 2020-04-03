

public class MonotonicArray {

    public static boolean isMonotonic(int[] array) {
        if (array.length == 0) {
            return true;
        }

        if (array.length <= 2) {
            return true;
        }

        boolean increasing = checkIfIncreasing(array);

        if(increasing) {

            for (int i = 1; i < array.length - 1; i++) {
                if (array[i + 1] < array[i]) {
                    return false;
                }
            }

        } else {
            for (int i = 1; i < array.length - 1; i++) {
                if (array[i + 1] > array[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkIfIncreasing(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] == array[i]) {
                continue;
            }

            if (array[i + 1] > array[i]) {
                return true;
            }
        }
        return false;
    }
}
