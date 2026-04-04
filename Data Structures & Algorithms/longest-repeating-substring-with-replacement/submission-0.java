class Solution {
    public int characterReplacement(String s, int k) {
        int result = 0;
        HashMap<Character, Integer> freqMap = new HashMap<>();
        char[] charArr = s.toCharArray();

        int l = 0;
        int r = 0;

        freqMap.put(charArr[0], 1);

        while (l<=r && r < s.length()) {
            int winLen = r - l + 1;
            int maxValue = 0;
            for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
                maxValue = Math.max(maxValue, entry.getValue());
            }

            if (winLen - maxValue <= k) {
                r++;
                if (r < s.length() && freqMap.containsKey(charArr[r])) {
                    freqMap.put(charArr[r], freqMap.get(charArr[r]) + 1);
                } else if (r < s.length()) {
                    freqMap.put(charArr[r], 1);
                }

                result = Math.max(result, winLen);

            } else {
                freqMap.put(charArr[l], freqMap.get(charArr[l]) - 1);
                l++;
            }
        }
        return result;
    }
}
