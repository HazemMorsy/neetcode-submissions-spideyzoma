class Solution {
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return isPlaindrome(s.substring(0, l) + s.substring(l+1)) ||
                isPlaindrome(s.substring(0, r) + s.substring(r+1));
            }
        }
        return true;
    }

    private boolean isPlaindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return false;
            }

        }

        return true;
    }
}