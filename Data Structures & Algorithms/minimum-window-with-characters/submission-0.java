class Solution {
    public String minWindow(String s, String t) {

        if (t.length() > s.length()) {
            return "";
        }

        HashMap<Character, Integer> needMap = new HashMap<>();
        HashMap<Character, Integer> haveMap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            needMap.put(t.charAt(i), needMap.getOrDefault(t.charAt(i), 0) + 1);
            haveMap.put(t.charAt(i), 0);
        }

        int needCounter = needMap.size();
        int haveCounter = 0;

        int ans = Integer.MAX_VALUE;
        int ansStart = 0;
        int ansEnd = s.length() - 1;

        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);

            if (needMap.containsKey(c)) {
                haveMap.put(c, haveMap.getOrDefault(c, 0) + 1);

                if (haveMap.get(c) == needMap.get(c)) {
                    haveCounter++;
                }
            }

            while (haveCounter == needCounter) {
                if (r - l + 1 < ans) {
                    ans = r - l + 1;
                    ansStart = l;
                    ansEnd = r;
                }

                char lchar = s.charAt(l);
                if (needMap.containsKey(lchar)) {
                    haveMap.put(lchar, haveMap.get(lchar) - 1);
                    if (haveMap.get(lchar) < needMap.get(lchar)) {
                        haveCounter--;
                    }
                }

                l++;
            }

        }

        return ans == Integer.MAX_VALUE ? "" : s.substring(ansStart, ansEnd + 1);

    }
}