import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ShortenPath {
    public static String shortenPath(String path) {
        boolean startsAtRootDirectory = path.charAt(0) == '/';
        String[] array = path.split("/");
        List<String> tokens = new ArrayList<>(Arrays.asList(array));

        List<String> filteredTokens = tokens.stream()
                                        .filter(ShortenPath::isImportantToken)
                                        .collect(Collectors.toList());
        List<String> stack = new ArrayList<>();
        if(startsAtRootDirectory) {
            stack.add("");
        }

        for (String token : filteredTokens) {

            if (token.equals("..")) {

                if (stack.size() == 0 || stack.get(stack.size() - 1).equals("..")) {
                    stack.add("..");
                } else if (!stack.get(stack.size() - 1).equals("")) {
                    stack.remove(stack.size() - 1);
                }
            } else {
                stack.add(token);
            }
        }

        if (stack.size() == 1 && stack.get(0).equals("")) {
            return "/";
        }
        return String.join("/", stack);
    }

    public static boolean isImportantToken(String string) {
        return string.length() > 0 && !string.equals(".");
    }
}
