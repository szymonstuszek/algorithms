import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiStringSearch {
    public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
        ModifiedSuffixTrie trie = new ModifiedSuffixTrie(bigString);
        List<Boolean> solution = new ArrayList<>();

        for (String smallString : smallStrings) {
            solution.add(trie.contains(smallString));
        }

        return solution;
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
    }

    static class ModifiedSuffixTrie {
        TrieNode root = new TrieNode();

        public ModifiedSuffixTrie(String string) {
            populateModifiedSuffixTrie(string);
        }

        private void populateModifiedSuffixTrie(String string) {

            for (int i = 0; i < string.length(); i++) {
                insertSubstringStartingAt(i, string);
            }
        }

        private void insertSubstringStartingAt(int i, String string) {
            TrieNode node = root;
            for (int j = i; j < string.length(); j++) {

                char letter = string.charAt(j);
                if (!node.children.containsKey(letter)) {
                    node.children.put(letter, new TrieNode());
                }

                node = node.children.get(letter);
            }
        }

        public boolean contains(String string) {
            TrieNode node = root;

            for (int i = 0; i < string.length(); i++) {
                char letter = string.charAt(i);

                if (!node.children.containsKey(letter)) {
                    return false;
                }
                node = node.children.get(letter);
            }

            return true;
        }
    }


    //time complexity bns, space n
//    public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
//        List<Boolean> solution = new ArrayList<>();
//
//        for (String smallString : smallStrings) {
//            solution.add(isInBigString(bigString, smallString));
//        }
//
//        return solution;
//    }
//
//    private static boolean isInBigString(String bigString, String smallString) {
//
//        for (int i = 0; i < bigString.length(); i++) {
//            if (i + smallString.length() > bigString.length()) {
//                return false;
//            }
//
//            if (isInBigString(bigString, smallString, i)) {
//                return true;
//            }
//        }
//
//        return false;
//    }
//
//    private static boolean isInBigString(String bigString, String smallString, int startIndex) {
//        int leftBigIdx = startIndex;
//        int rightBigIdx = startIndex + smallString.length() - 1;
//        int leftSmallIdx = 0;
//        int rightSmallIdx = smallString.length() - 1;
//
//        while (leftBigIdx <= rightBigIdx) {
//            if (bigString.charAt(leftBigIdx) != smallString.charAt(leftSmallIdx) ||
//                    bigString.charAt(rightBigIdx) != smallString.charAt(rightSmallIdx)) {
//                return false;
//            }
//            leftBigIdx++;
//            leftSmallIdx++;
//            rightBigIdx--;
//            rightSmallIdx--;
//        }
//        return true;
//    }
}
