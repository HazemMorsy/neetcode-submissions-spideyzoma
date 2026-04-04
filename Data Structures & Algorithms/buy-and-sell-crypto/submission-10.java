class Solution {
    public int maxProfit(int[] prices) {
        // 10,9,2,5,1,7,1
        // 10,9,2,10,2,7,1


        int maxProfit = 0;
        int l = 0;
        int r = 1;

        while (r < prices.length) {
            if (prices[l] > prices[r]) {
                // loss
                // advance l to point to r as it has a lower value 
                // (potential for larger profit)
                l = r;
            } else {
                maxProfit = Math.max(maxProfit, prices[r] - prices[l]);
            }

            r++;
        }

        return maxProfit;


    }
}
