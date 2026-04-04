class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        } 

        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();

        HashMap<Character, Integer> mapOfS1 = new HashMap<>();
        for (char c : s1Arr) {
            mapOfS1.put(c, mapOfS1.getOrDefault(c, 0) + 1);
        }

        int l=0;
        int r=s1.length()-1;

        HashMap<Character, Integer> mapOfS2 = new HashMap<>();
        for (int j=0;j<=r;j++) {
            mapOfS2.put(s2Arr[j], mapOfS2.getOrDefault(s2Arr[j], 0) + 1);
        }

        while (r < s2.length()) {
            if (mapOfS1.equals(mapOfS2)) {
                return true;
            }

            if (r + 1 == s2.length()) {
                return false;
            }

            if (mapOfS2.get(s2Arr[l]) == 1) {
                mapOfS2.remove(s2Arr[l]);
            } else {
                mapOfS2.put(s2Arr[l], mapOfS2.getOrDefault(s2Arr[l], 0) - 1);
            }

            mapOfS2.put(s2Arr[r+1], mapOfS2.getOrDefault(s2Arr[r+1], 0) + 1);
            l++;
            r++;
        }

        return false;

    }
}
