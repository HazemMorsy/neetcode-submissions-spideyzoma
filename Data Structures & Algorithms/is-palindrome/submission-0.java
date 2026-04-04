class Solution {
    public boolean isPalindrome(String s) {
        String alphaNumericStr = "";

        for (char c : s.toCharArray()) {
            if (isAlphaNumeric(c)) {
                alphaNumericStr += c;
            }
        }

        alphaNumericStr = alphaNumericStr.toLowerCase();
        return isPlaindrome(alphaNumericStr);
    }

    private boolean isPlaindrome(String s) {
        int start = 0;
        int end = s.length()-1;

        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }


    private boolean isAlphaNumeric(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }
}
