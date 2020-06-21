import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutDuplication {
    public static String longestSubstringWithoutDuplication(String str) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        int[] longest = {0, 1};
        int startIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            if (lastSeen.containsKey(current)) {
                startIndex = Math.max(startIndex, lastSeen.get(current) + 1);
            }
            if (longest[1] - longest[0] < i + 1 - startIndex) {
                longest = new int[]{startIndex, i + 1};
            }
            lastSeen.put(current, i);
        }

        return str.substring(longest[0], longest[1]);
    }
}
