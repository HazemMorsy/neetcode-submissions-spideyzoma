class Solution {


    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxLeft = height[l];
        int maxRight = height[r];
        int totalArea = 0;
        while (l < r) {
            int currMinBoundary = Math.min(maxLeft, maxRight);
            if (height[l] <= height[r]) {
                l++;
                if (height[l] < currMinBoundary) {
                    totalArea += (currMinBoundary - height[l]);
                }
            } else {
                r--;
                if (height[r] < currMinBoundary) {
                    totalArea += (currMinBoundary - height[r]);
                }
            }
            maxLeft = Math.max(maxLeft, height[l]);
            maxRight = Math.max(maxRight, height[r]);
        }

        return totalArea;
    }
}
