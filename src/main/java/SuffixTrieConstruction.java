import java.util.HashMap;
import java.util.Map;

public class SuffixTrieConstruction {

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    }

    static class SuffixTrie {
        TrieNode root = new TrieNode();
        char endSymbol = '*';

        public SuffixTrie(String str) {
            populateSuffixTrieFrom(str);
        }

        public void populateSuffixTrieFrom(String str) {
            for (int i = 0; i < str.length(); i++) {
                TrieNode currentNode = root;
                for (int j = i; j < str.length(); j++) {
                    char currentCharacter = str.charAt(i);

                    if (!currentNode.children.containsKey(currentCharacter)) {
                        TrieNode node = new TrieNode();
                        currentNode.children.put(currentCharacter, node);

                    }
                }
                currentNode.children.put(endSymbol, null);
            }
        }

        public boolean contains(String str) {
            TrieNode currentNode = root;

            for (int i = 0; i < str.length(); i++) {
                char currentCharacter = str.charAt(i);
                if (!currentNode.children.containsKey(currentCharacter)) {
                    return false;
                }
                currentNode = currentNode.children.get(currentCharacter);
            }
            return currentNode.children.containsKey(endSymbol);
        }
    }
}
