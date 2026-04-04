class Solution {


    // low -------------- high
    // ->lower         <-lower (no gain)
    // ->higher(best)        <-higher (no gain == loss in width and same height)

    // moving from lower has higher chances 

    public int trap(int[] height) {
        int [] maxLeft = new int[height.length];
        int [] maxRight = new int[height.length];

        for (int i=1;i<height.length;i++) {
            maxLeft[i] = Math.max(maxLeft[i-1], height[i-1]);
        }

        for (int i=height.length-2;i>=0;i--) {
            maxRight[i] = Math.max(maxRight[i+1], height[i+1]);
        }

        int totalArea = 0;
        for (int i=0;i<height.length;i++) {
            int currMinBoundary = Math.min(maxLeft[i], maxRight[i]);
            if (height[i] < currMinBoundary) {
                totalArea += (currMinBoundary - height[i]);
            }
        }

        return totalArea;
    }
}
