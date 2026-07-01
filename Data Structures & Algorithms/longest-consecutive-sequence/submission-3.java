class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxSeq = 0;
        for (int val : set) {
            // meaning we checked it already before
            if (set.contains(val-1)) {
                continue;
            }

            // lowest element in the sequence
            int currVal = val;
            while (set.contains(currVal)) {
                currVal++;
            }

            maxSeq = Math.max(maxSeq, currVal - val);
        }

        return maxSeq;
    }
}
