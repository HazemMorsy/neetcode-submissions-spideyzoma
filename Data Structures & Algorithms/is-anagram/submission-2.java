class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int [] indexS = new int[26];
        int [] indexT = new int[26];

        for (char c : s.toCharArray()) {
            indexS[c-'a']++;
        }

        for (char c : t.toCharArray()) {
            indexT[c-'a']++;
        }

        for (int i = 0; i<26;i++) {
            if (indexS[i] != indexT[i]) {
                return false;
            }
        }

        return true;

        // HashMap<Character, Integer> map = new HashMap<>();
        // for (char c : s.toCharArray()) {
        //     if (map.containsKey(c)) {
        //         map.put(c, map.get(c) + 1);
        //     } else {
        //         map.put(c, 1);
        //     }
        // }

        // for (char c : t.toCharArray()) {
        //     if (!map.containsKey(c)) {
        //         return false;
        //     } else {
        //         map.put(c, map.get(c) - 1);
        //     }
        // }

        // for (Map.Entry<Character, Integer> entry: map.entrySet()) {
        //     if (entry.getValue() != 0) {
        //         return false;
        //     }
        // }

        // return true;


    }
}
