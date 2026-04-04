class Solution {
    public int trap(int[] height) {
        int l=0;
        int r=height.length-1;

        int maxLeft = height[l];
        int maxRight = height[r];
        int totalRes= 0;

        while (l < r) {
            if (height[l] <= height[r]) {
                l++;
                maxLeft = Math.max(maxLeft, height[l]);
                totalRes += maxLeft - height[l];
            } else {
                r--;
                maxRight = Math.max(maxRight, height[r]);
                totalRes += maxRight - height[r];
            }
        }

        return totalRes;
    }
}
