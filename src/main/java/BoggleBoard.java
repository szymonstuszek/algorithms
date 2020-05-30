import java.util.*;

public class BoggleBoard {

    public static List<String> boggleBoard(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.add(word);
        }

        Set<String> finalWords = new HashSet<>();
        boolean[][] visits = new boolean[board.length][board[0].length];

        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                explore(board, visits, row, column, trie.root, finalWords);
            }
        }

        return new ArrayList<>(finalWords);
    }

    public static void explore(char[][] board, boolean[][] visits,
                        int row, int column,
                        TrieNode trieNode, Set<String> finalWords) {

        if (visits[row][column]) {
            return;
        }

        char currentChar = board[row][column];
        if (!trieNode.children.containsKey(currentChar)) {
            return;
        }

        visits[row][column] = true;
        trieNode = trieNode.children.get(currentChar);

        if (trieNode.children.containsKey('*')) {
            finalWords.add(trieNode.word);
        }

        List<Integer[]> neighbours = getNeighbours(board, row, column);

        for (Integer[] coordinate : neighbours) {
            explore(board, visits, coordinate[0], coordinate[1], trieNode, finalWords);
        }

        visits[row][column] = false;
    }

    public static List<Integer[]> getNeighbours(char[][] board, int row, int column) {
        List<Integer[]> neighbours = new ArrayList<>();

        if (row > 0 && column > 0) {
            neighbours.add(new Integer[]{row - 1, column - 1});
        }

        if (row > 0) {
            neighbours.add(new Integer[]{row - 1, column});
        }

        if (row > 0 && column < board[0].length - 1) {
            neighbours.add(new Integer[]{row - 1, column + 1});
        }

        if (column > 0) {
            neighbours.add(new Integer[]{row, column - 1});
        }

        if (column < board[0].length - 1) {
            neighbours.add(new Integer[]{row, column + 1});
        }

        if (row < board.length - 1 && column > 0) {
            neighbours.add(new Integer[]{row + 1, column - 1});
        }

        if (row < board.length - 1) {
            neighbours.add(new Integer[]{row + 1, column});
        }

        if (row < board.length - 1 && column < board[0].length - 1) {
            neighbours.add(new Integer[]{row + 1, column + 1});
        }

        return neighbours;
    }

    static class TrieNode {
        private Map<Character, TrieNode> children = new HashMap<>();
        private String word = "";
    }

    static class Trie {
        private TrieNode root;
        private char endSymbol = '*';

        public Trie() {
            root = new TrieNode();
        }

        public void add(String word) {
            TrieNode currentNode = root;

            for (int i = 0; i < word.length(); i++) {
                char symbol = word.charAt(i);

                if (!currentNode.children.containsKey(symbol)) {
                    currentNode.children.put(symbol, new TrieNode());
                }

                currentNode = currentNode.children.get(symbol);
            }
            currentNode.children.put(endSymbol, null);
            currentNode.word = word;
        }
    }
}
