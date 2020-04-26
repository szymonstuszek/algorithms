import java.util.ArrayList;
import java.util.List;

public class SameBsts {
    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {

        if (arrayOne.size() != arrayTwo.size()) {
            return false;
        }

        if (arrayOne.size() == 0 && arrayTwo.size() == 0) {
            return true;
        }

        if (!arrayOne.get(0).equals(arrayTwo.get(0))) {
            return false;
        }

        List<Integer> arrayOneLeftSide = getSmaller(arrayOne.get(0), arrayOne);
        List<Integer> arrayOneRightSide = getBiggerOrEqual(arrayOne.get(0), arrayOne);
        List<Integer> arrayTwoLeftSide = getSmaller(arrayTwo.get(0), arrayTwo);
        List<Integer> arrayTwoRightSide = getBiggerOrEqual(arrayTwo.get(0), arrayTwo);

        return sameBsts(arrayOneLeftSide, arrayTwoLeftSide) && sameBsts(arrayOneRightSide, arrayTwoRightSide);
    }

    private static List<Integer> getSmaller(int value, List<Integer> array) {
        List<Integer> smallerThanGivenValueList = new ArrayList<>();
        for (int i = 1; i < array.size(); i++) {
            int currentValue = array.get(i);
            if (currentValue < value) {
                smallerThanGivenValueList.add(currentValue);
            }
        }
        return smallerThanGivenValueList;
    }

    private static List<Integer> getBiggerOrEqual(int value, List<Integer> array) {
        List<Integer> greaterThanGivenValueList = new ArrayList<>();
        for (int i = 1; i < array.size(); i++) {
            int currentValue = array.get(i);
            if (currentValue >= value) {
                greaterThanGivenValueList.add(currentValue);
            }
        }
        return greaterThanGivenValueList;
    }
}
