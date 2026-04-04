class Solution {
    public int characterReplacement(String s, int k) {
        // AABBABB, 1
        // O(n) more percisely O(26*n)

        int l = 0;
        int r = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxRes = 0;
        int maxFreq = 0;
        while (r < s.length()) {

            int currLength = r - l + 1;
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(s.charAt(r)));
            while (currLength - maxFreq > k) {
                if (map.get(s.charAt(l)) > 1) {
                    map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                } else {
                    map.remove(s.charAt(l));
                }
                // have to update the length again as we are moving l pointer
                l++;
                currLength = r - l + 1;
            }
            r++;
            maxRes = Math.max(maxRes, currLength);

        }

        return maxRes;
    }

    // equation (currLen - maxFreq <= k)
    // for eg (assuming k = 2)  5(currLen) - 3(max Freq) <= 2
    // for updating the results we have two options 
    // 1) increasing the length leads to increase in the freq
        // will detect it normally by keeping track of the max val
    // 2) shrinking the length leads to decrement in freq
        // we don't care as this will lead to decrement in currentLenght value (which we only care about the max value)
}
