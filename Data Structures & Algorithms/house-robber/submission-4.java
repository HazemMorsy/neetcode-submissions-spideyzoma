class Solution {
    public int rob(int[] nums) {
        int maxSum [] = new int[nums.length];
        maxSum[nums.length-1] = nums[nums.length-1];
        if (nums.length == 1) {
            return nums[0];
        }
        for (int i=nums.length-2;i>=0;i--) {
            if (i < nums.length-2){
                maxSum[i] = Math.max(nums[i] + maxSum[i+2], nums[i] + maxSum[i+1] - nums[i+1]);
            } else {
                maxSum[i] = Math.max(nums[i] , nums[i] + maxSum[i+1] - nums[i+1]);
            }
        }

        return Math.max(maxSum[0], maxSum[1]);

    }
}
