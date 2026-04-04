class Solution {
    public boolean checkInclusion(String s1, String s2) {    
        if (s2.length() < s1.length()) {
            return false;
        }

        // s1 : abc
        // s2 : ktcbatw

        int l = 0;
        int r = s1.length() - 1;

        HashMap<Character, Integer> map1 = new HashMap<>();
        for (int i=0;i < s1.length();i++) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
        }

        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i=0;i < s1.length() - 1;i++) {
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
        }

        while (r < s2.length()) {
            map2.put(s2.charAt(r), map2.getOrDefault(s2.charAt(r), 0) + 1);
            if (map1.equals(map2)) {
                return true;
            }
            if (map2.get(s2.charAt(l)) > 1) {
                map2.put(s2.charAt(l), map2.get(s2.charAt(l)) - 1);
            } else {
                map2.remove(s2.charAt(l));
            }
            l++;
            r++;
        }

        return false;


    }
}
