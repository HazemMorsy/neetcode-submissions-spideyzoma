class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxVal = 0;
        for (int pile : piles) {
            maxVal = Math.max(maxVal, pile);
        }

        int l = 1;
        int r = maxVal;

        while (l < r) {
            int m = l + (r - l) / 2;
            int currHours = calcHours(piles, m);
            if (currHours <= h) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;


    }

    private int calcHours(int[] piles, int rate) {
        int totalHours = 0;
        for (int pile : piles) {
            totalHours += Math.ceil(pile / (rate * 1.0));
        }
        return totalHours;
    }
}
