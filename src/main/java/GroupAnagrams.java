import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(List<String> words) {
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            List<String> entry;

            if (anagramMap.containsKey(sorted)) {
                entry = anagramMap.get(sorted);
                entry.add(word);
            } else {
                entry = new ArrayList<>();
                entry.add(word);
                anagramMap.put(sorted, entry);
            }
        }

        return new ArrayList<>(anagramMap.values());
    }
}
