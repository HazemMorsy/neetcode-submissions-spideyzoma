class Solution {
    public int characterReplacement(String s, int k) {

        // AABBABB, 1

        int ans = 0;
        for (int i=0;i<s.length();i++) {
            HashMap<Character, Integer> map = new HashMap<>();
            char maxKey = 'a';
            int maxVal = 0;
            for (int j=i;j<s.length();j++) {
                String currStr = s.substring(i, j+1);
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                int currVal = map.get(s.charAt(j));
                // do the check on inserting any new record in the map
                // instead of reading the whole map again  
                if (currVal > maxVal) {
                    maxVal = currVal;
                    maxKey = s.charAt(j);
                }

                // char maxChar = getMaxFreq(map);
                // int maxVal = map.get(maxChar);
                int needReplacement = currStr.length() - maxVal;

                if (needReplacement <= k) {
                    ans = Math.max(ans, currStr.length());
                }

            }
        }

        return ans;
    }

    private char getMaxFreq(HashMap<Character, Integer> map) {
        char maxKey = 'a';
        int maxVal = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxVal) {
                maxVal = entry.getValue();
                maxKey = entry.getKey();
            }
        }

        return maxKey;
    }
}
