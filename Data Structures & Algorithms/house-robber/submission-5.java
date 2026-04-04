class Solution {
    public int rob(int[] nums) {
        int prev1 = 0;
        int prev2 = 0;
        for (int n:nums) {
            int max = Math.max(n+prev1, prev2);
            prev1 = prev2;
            prev2 = max;
        }
        return prev2;
    }
}
