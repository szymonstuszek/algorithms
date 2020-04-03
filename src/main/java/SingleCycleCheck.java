import java.util.Arrays;
import java.util.stream.IntStream;

public class SingleCycleCheck {
    public static boolean hasSingleCycle(int[] array) {
        int[] arrayOfVisits = new int[array.length];
        int numberOfElements = array.length;
        int sumOfElements = 0;
        int i = 0;

        while (numberOfElements != sumOfElements) {
            int jumpBy = array[i];
            i = calculatePosition(jumpBy + i, numberOfElements);
            arrayOfVisits[i] += 1;

            if (anyIndexVisitedMoreThanOnce(arrayOfVisits)) {
                return false;
            }

            sumOfElements = getSumOfElements(arrayOfVisits);
        }

        return Arrays.stream(arrayOfVisits)
                .allMatch(n -> n == 1);
    }

    private static int calculatePosition(int currentJump, int numberOfElements) {
        if (currentJump >= 0 && currentJump < numberOfElements) {
            return currentJump;
        }

        int moveBy = currentJump % numberOfElements;

        if (moveBy > 0) {
            return moveBy;
        }

        if (moveBy < 0) {
            return numberOfElements + moveBy;
        }
        return moveBy;
    }

    private static int getSumOfElements(int[] array) {
        return IntStream.of(array).sum();
    }

    private static boolean anyIndexVisitedMoreThanOnce(int[] array) {
        return Arrays.stream(array)
                .anyMatch(n -> n > 1);
    }
}
