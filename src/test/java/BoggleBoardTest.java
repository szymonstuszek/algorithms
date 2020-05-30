import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoggleBoardTest {


    @Test
    public void testBoggleBoard() {
        char[][] board = {
                {'t', 'h', 'i', 's', 'i', 's', 'a'},
                {'s', 'i', 'm', 'p', 'l', 'e', 'x'},
                {'b', 'x', 'x', 'x', 'x', 'e', 'b'},
                {'x', 'o', 'g', 'g', 'l', 'x', 'o'},
                {'x', 'x', 'x', 'D', 'T', 'r', 'a'},
                {'R', 'E', 'P', 'E', 'A', 'd', 'x'},
                {'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                {'N', 'O', 'T', 'R', 'E', '-', 'P'},
                {'x', 'x', 'D', 'E', 'T', 'A', 'E'}
        };

        String[] words = {
                "this",
                "is",
                "not",
                "a",
                "simple",
                "boggle",
                "board",
                "test",
                "REPEATED",
                "NOTRE-PEATED"
        };

        List<String> expected = new ArrayList<>(
                Arrays.asList("NOTRE-PEATED", "a", "board", "boggle", "is", "simple", "this")
        );

        List<String> result = BoggleBoard.boggleBoard(board, words);

        Assert.assertTrue(expected.containsAll(result) && result.containsAll(expected));
    }

    @Test
    public void testBoggleBoardTrieConstruction() {
        String word1 = "this";
        String word2 = "toggle";

        BoggleBoard.Trie trie = new BoggleBoard.Trie();

        trie.add(word1);
    }
}
