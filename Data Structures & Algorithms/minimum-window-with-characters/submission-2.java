class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        // s: OUZXYODYXAZV , t: XYZ
        // s: a , t: a
        // The main idea is that we have to check 
        // the freq of different characters on adding new char to our window
        // so instead of comparing the maps on each char
        // we can instead keep (have & need) variables which keep track of this comparison for us
        HashMap<Character, Integer> mapT = new HashMap<>();
        for (int i=0;i<t.length();i++) {
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }

        int need = mapT.size();
        int have = 0;
        int minLen = Integer.MAX_VALUE;
        String res = "";

        HashMap<Character, Integer> mapWin = new HashMap<>();
        int l = 0;
        int r = 0;
        for (r = 0;r < s.length();r++) {
            if (mapT.containsKey(s.charAt(r))) {
                mapWin.put(s.charAt(r), mapWin.getOrDefault(s.charAt(r), 0) + 1);
                // only increment in case of a char in both maps are exactly the same
                if (mapWin.get(s.charAt(r)) == mapT.get(s.charAt(r))) {
                    have++;
                }
            }

            while (have == need) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    res = s.substring(l , r + 1);
                }

                if (l < s.length() && mapWin.containsKey(s.charAt(l))) {
                    mapWin.put(s.charAt(l), mapWin.get(s.charAt(l)) - 1);
                    // decrement have if value of char in the window decreases on what is there in mapT
                    if (mapWin.get(s.charAt(l)) < mapT.get(s.charAt(l))) {
                        have--;
                    }
                }
                l++;
            }
        }

        return res;
        
    }
}
