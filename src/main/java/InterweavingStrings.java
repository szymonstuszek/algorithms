

public class InterweavingStrings {

    public static boolean interweavingStrings(String one, String two, String three) {
        if (one.length() + two.length() != three.length()) {
            return false;
        }

        Boolean[][] cache = new Boolean[one.length() + 1][two.length() + 1];
        return areInterwoven(one, two, three, 0, 0, cache);
    }

    public static boolean areInterwoven(String one, String two, String three, int i, int j, Boolean[][] cache) {

        if (cache[i][j] != null) {
            return cache[i][j];
        }

        int indexInResultString = i + j;

        if (indexInResultString == three.length()) {
            return true;
        }

        if (i < one.length() && one.charAt(i) == three.charAt(indexInResultString)) {
            cache[i][j] = areInterwoven(one, two, three, i + 1, j, cache);
            if (cache[i][j]) {
                return true;
            }
        }

        if (j < two.length() && two.charAt(j) == three.charAt(indexInResultString)) {
            cache[i][j] = areInterwoven(one, two, three, i, j + 1, cache);
            if (cache[i][j]) {
                return true;
            }
        }

        cache[i][j] = false;

        return false;
    }
}
