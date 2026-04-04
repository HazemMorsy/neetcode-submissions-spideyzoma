class Solution {
    public int climbStairs(int n) {
        // [ 1 -> 1, 2 -> 2 , 3 -> 3, 4 -> ]
        // 1 1 1 1
        // 1 2 1
        // 2 1 1
        // 2 2
        // 1 1 2

        int [] dp = new int[n];
        for (int i=0;i<n;i++) {
            if (i <= 1) {
                dp[i] = i+1;
            } else {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }

        return dp[n-1];
    }
}
