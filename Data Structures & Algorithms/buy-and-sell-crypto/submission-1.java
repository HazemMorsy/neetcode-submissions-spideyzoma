class Solution {
    public int maxProfit(int[] prices) {
        int totalMax = 0;
        for (int i=0;i<prices.length;i++) {
            int currMax = 0;
            for (int j=i+1;j<prices.length;j++) {
                currMax = Math.max(currMax, prices[j] - prices[i]);
            }
            totalMax = Math.max(totalMax, currMax);
        }

        return totalMax;
    }
}
