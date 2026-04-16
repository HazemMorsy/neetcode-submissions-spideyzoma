class Solution {
    public int largestRectangleArea(int[] heights) {

        // [2,5,4]
        // [0,1,2]
        
        int maxArea = 0;
        Stack<int[]> stack = new Stack<>();

        for (int i = 0;i < heights.length;i++) {
            if (stack.isEmpty() || stack.peek()[1] <= heights[i]) {
                // heights are in increasing order
                stack.push(new int[]{i, heights[i]});
            } else {
                int idx = i;
                while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                    int[] top = stack.pop();
                    idx = top[0];
                    maxArea = Math.max(maxArea, (i - top[0]) * top[1]);
                }
                stack.push(new int[]{idx, heights[i]});
            }
        }
        int currSize = stack.size();
        while (!stack.isEmpty()) {
            int[] top = stack.pop();
            maxArea = Math.max(maxArea, (heights.length - top[0]) * top[1]);
        }

        return maxArea;

    }
}
