class Solution {
    public int maxArea(int[] heights) {
        int start = 0;
        int end = heights.length - 1;

        int maxArea = 0;

        while (start < end) {
            int currArea = (end - start) * Math.min(heights[start], heights[end]);
            maxArea = Math.max(maxArea, currArea);
            if (heights[start] < heights[end]) {
                start++;
            } else {
                end--;
            }
        }

        return maxArea;

    }
}
