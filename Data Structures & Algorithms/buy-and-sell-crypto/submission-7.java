class Solution {
    public int maxProfit(int[] prices) {
        // 10,9,2,5,1,7,1
        // 10,9,2,10,2,7,1

        int [] maxPrice = new int[prices.length];
        maxPrice[prices.length-1] = prices[prices.length-1];

        for (int i=prices.length-2;i>=0;i--) {
            maxPrice[i] = Math.max(maxPrice[i+1], prices[i]);
        }

        int maxProfit = 0;
        for (int i=0;i<prices.length;i++) {
            maxProfit = Math.max(maxProfit, maxPrice[i] - prices[i]);
        }

        return maxProfit;
    }
}
