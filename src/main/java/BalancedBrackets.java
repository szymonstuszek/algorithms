import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BalancedBrackets {
    private final static String OPENING_BRACKETS = "([{";
    private final static String CLOSING_BRACKETS = ")]}";

    public static boolean balancedBrackets(String str) {
        List<Character> bracketStack = new ArrayList<>();
        Map<Character, Character> bracketDictionary = new HashMap<>();
        bracketDictionary.put(')', '(');
        bracketDictionary.put(']', '[');
        bracketDictionary.put('}', '{');

        int index = 0;

        while (index < str.length()) {
            char currentCharacter = str.charAt(index);

            if (OPENING_BRACKETS.indexOf(currentCharacter) != -1) {
                bracketStack.add(currentCharacter);
            } else if (CLOSING_BRACKETS.indexOf(currentCharacter) != -1) {

                if (bracketStack.size() == 0) {
                    return false;
                }

                char correspondingBracket = bracketDictionary.get(currentCharacter);

                if(bracketStack.get(bracketStack.size() - 1) == correspondingBracket) {
                    bracketStack.remove(bracketStack.size() - 1);
                } else {
                    return false;
                }
            }
            index++;
        }
        return bracketStack.size() == 0;
    }
}
