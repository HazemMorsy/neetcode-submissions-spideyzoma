class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        int res = 0;
        HashSet<Character> set = new HashSet<>();

        while (r < s.length()) {

            while (!set.isEmpty() && set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }

            set.add(s.charAt(r));
            r++;

            res = Math.max(res, r-l);
        }

        // while (r < s.length()) {
        //     if (set.isEmpty() || !set.contains(s.charAt(r))) {
        //         set.add(s.charAt(r));
        //         r++;
        //     } else {
        //         while (l < s.length() && set.contains(s.charAt(r))) {
        //             set.remove(s.charAt(l));
        //             l++;
        //         }
        //     }

        //     res = Math.max(res, r - l);
            
        // }

        return res;
    }
}
