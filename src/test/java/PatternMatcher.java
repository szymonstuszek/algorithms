import java.util.HashMap;
import java.util.Map;

public class PatternMatcher {

    public static String[] patternMatcher(String pattern, String str) {
        if (pattern.length() > str.length()) {
            return new String[]{};
        }

        String currentPattern = getNewPattern(pattern);
        boolean needToSwitch = pattern.charAt(0) == 'y';
        Map<Character, Integer> occurences = getOccurencesMap(currentPattern);
        int firstYPosition = getFirstYPosition(currentPattern);

        if (occurences.get('y') != 0) {

            for (int lengthOfX = 1; lengthOfX < str.length(); lengthOfX++) {

                int countOfX = occurences.get('x');
                int countOfY = occurences.get('y');
                int lengthOfY = (str.length() - countOfX * lengthOfX) / countOfY;

                if (lengthOfY % 1 != 0 || lengthOfY <= 0) {
                    continue;
                }

                int yIdx = firstYPosition * lengthOfX;
                String x = str.substring(0, lengthOfX);
                String y = str.substring(yIdx, yIdx + lengthOfY);
                String result = buildStringFromPattern(currentPattern, x, y);
                if (result.equals(str)) {
                    return needToSwitch ? new String[]{y, x} : new String[]{x, y};
                }
            }

        } else {

            int lengthOfX = str.length() / occurences.get('x');

            if (lengthOfX % 1 == 0) {

                String x = str.substring(0, lengthOfX);
                String result = buildStringFromPattern(currentPattern, x, "");
                if (result.equals(str)) {
                    return needToSwitch ? new String[]{"", x} : new String[]{x, ""};
                }
            }
        }


        return new String[]{};
    }

    public static String getNewPattern(String pattern) {
        char[] patternLetters = pattern.toCharArray();
        if (patternLetters[0] == 'x') {
            return pattern;
        }

        for (int i = 0; i < patternLetters.length; i++) {
            if (patternLetters[i] == 'x') {
                patternLetters[i] = 'y';
            } else {
                patternLetters[i] = 'x';
            }
        }

        return new String(patternLetters);
    }

    public static int getFirstYPosition(String pattern) {
        int position = -1;

        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'y') {
                position = i;
                break;
            }
        }

        return position;
    }

    public static Map<Character, Integer> getOccurencesMap(String pattern) {
        Map<Character, Integer> occurences = new HashMap<>();
        occurences.put('x', 0);
        occurences.put('y', 0);

        for (int i = 0; i < pattern.length(); i++) {
            char currentChar = pattern.charAt(i);
            occurences.put(currentChar, occurences.get(currentChar) + 1);
        }

        return occurences;
    }

    public static String buildStringFromPattern(String pattern, String x, String y) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'x') {
                builder.append(x);
            } else {
                builder.append(y);
            }
        }

        return builder.toString();
    }
}
