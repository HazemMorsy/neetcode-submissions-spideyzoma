class Solution {
    public int largestRectangleArea(int[] heights) {
        int [] minSoFar = new int[heights.length];
        minSoFar[heights.length-1] = heights[heights.length-1];

        int maxArea = 0;
        for (int i=0;i<heights.length;i++) {
            for (int j=i;j<heights.length;j++) {
                int minVal = getMinInRange(heights, i, j);
                maxArea = Math.max(maxArea, minVal * (j - i + 1));
            }
        }

        return maxArea;

    }


    private int getMinInRange(int[] heights, int i, int j) {
        int minVal = 1001;
        for (int k=i;k<=j;k++) {
            minVal = Math.min(minVal, heights[k]);
        }

        return minVal;
    }
}
