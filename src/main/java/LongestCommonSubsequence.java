import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubsequence {

    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        int[][] lengths = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 1; i < str1.length() + 1; i++) {
            for (int j = 1; j < str2.length() + 1; j++) {

                if (str2.charAt(j - 1) == str1.charAt(i - 1)) {
                    lengths[i][j] = lengths[i - 1][j - 1] + 1;
                } else {
                    lengths[i][j] = Math.max(lengths[i - 1][j], lengths[i][j - 1]);
                }
            }
        }

        return buildSequence(lengths, str2);
    }

    public static List<Character> buildSequence(int[][] lengths, String str2) {
        List<Character> lcs = new ArrayList<>();
        int i = lengths.length - 1;
        int j = lengths[0].length - 1;

        while (i != 0 && j != 0) {

            if (lengths[i][j] == lengths[i][j - 1]) {
                j--;
            } else if (lengths[i][j] == lengths[i - 1][j]) {
                i--;
            } else {
                i--;
                j--;
                lcs.add(0, str2.charAt(j));
            }

        }

        return lcs;
    }
}
