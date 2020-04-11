

public class LongestPalindromicSubstring {
    public static String longestPalindromicSubstring(String str) {
        int[] longestPalindrome = {0, 1};

        for (int i = 1; i < str.length(); i++) {

            int[] oddPalindrome = palindromeCheck(i - 1, i + 1, str);
            int[] evenPalindrome = palindromeCheck(i - 1, i, str);

            int[] currentLongestPalindrome =
                    oddPalindrome[1] - oddPalindrome[0] > evenPalindrome[1] - evenPalindrome[0]
                    ? oddPalindrome : evenPalindrome;

            if(currentLongestPalindrome[1] - currentLongestPalindrome[0] > longestPalindrome[1] - longestPalindrome[0]) {
                longestPalindrome = currentLongestPalindrome;
            }
        }

        return str.substring(longestPalindrome[0], longestPalindrome[1]);
    }


    private static int[] palindromeCheck(int leftIndex, int rightIndex, String str) {
        while (leftIndex >= 0 && rightIndex < str.length()) {
            if(str.charAt(leftIndex) == str.charAt(rightIndex)) {
                leftIndex--;
                rightIndex++;
            } else {
                break;
            }
        }

        return new int[]{leftIndex + 1, rightIndex};
    }
}
