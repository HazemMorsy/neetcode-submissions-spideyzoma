class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;
        s = s.toLowerCase();
        while (l < r) {
            while (l < s.length() && !isAlphaNumeric(s.charAt(l))) {
                l++;
            }
            while (r >=0 && !isAlphaNumeric(s.charAt(r))) {
                r--;
            }
            if (l == s.length() || r < 0) {
                return true;
            }
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }


    private boolean isAlphaNumeric(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}
