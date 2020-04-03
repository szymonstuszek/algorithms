import java.util.Arrays;

public class Levensthein {

    public static int levenshteinDistance(String str1, String str2) {
        str1 = " " + str1;
        str2 = " " + str2;

        int[][] edit = new int[str1.length() + 1][str2.length() + 1];

        for (int[] row : edit) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        edit[0][0] = 0;

        for (int r = 1; r < str1.length() + 1; r++) {
            char charInFirstString = str1.charAt(r - 1);

            for (int c = 1; c < str2.length() + 1; c++) {
                char charInSecondString = str2.charAt(c - 1);

                if (charInFirstString == charInSecondString) {
                    edit[r][c] = edit[r - 1][c - 1];
                } else {
                    edit[r][c] = 1 + Math.min(edit[r - 1][c], Math.min(edit[r - 1][c - 1], edit[r][c - 1]  ));
                }
            }
        }
        return edit[str1.length()][str2.length()];
    }
}
