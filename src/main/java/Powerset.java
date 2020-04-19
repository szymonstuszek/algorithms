import java.util.ArrayList;
import java.util.List;

public class Powerset {
    public static List<List<Integer>> powerset(List<Integer> array) {

        List<List<Integer>> resultList = new ArrayList<>();
        resultList.add(new ArrayList<>());

        for (int i = 0; i < array.size(); i++) {

            int currentInteger = array.get(i);
            int length = resultList.size();

            for (int j = 0; j < length; j++) {
                List<Integer> currentList = new ArrayList<>(resultList.get(j));
                currentList.add(currentInteger);
                resultList.add(currentList);
            }
        }

        return resultList;
    }
}
