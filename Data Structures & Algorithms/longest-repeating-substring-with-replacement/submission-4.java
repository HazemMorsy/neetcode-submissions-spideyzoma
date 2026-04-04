class Solution {
    public int characterReplacement(String s, int k) {
        // AABBABB, 1

        int l = 0;
        int r = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxRes = 0;

        while (r < s.length()) {

            int currLength = r - l + 1;
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            while (currLength - getMaxFreq(map) > k) {
                if (map.get(s.charAt(l)) > 1) {
                    map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                } else {
                    map.remove(s.charAt(l));
                }
                l++;
                currLength = r - l + 1;
            }
            r++;
            maxRes = Math.max(maxRes, currLength);

        }

        return maxRes;
    }

    private int getMaxFreq(HashMap<Character, Integer> map) {
        int maxVal = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            maxVal = Math.max(maxVal, entry.getValue());
        }

        return maxVal;
    }
}
