class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.equals("")){
            return 0;
        }

        char[] strChars = s.toCharArray();
        HashSet<Character> charSet = new HashSet<>();
        int maxLen = 1;
        int l = 0;

        for (int i=0;i<strChars.length;i++) {
            while (charSet.contains(strChars[i])) {
                charSet.remove(strChars[l]);
                l++;
            }
            charSet.add(strChars[i]);
            maxLen = Math.max(maxLen, i-l+1);
        }

        return maxLen;
    }
}
