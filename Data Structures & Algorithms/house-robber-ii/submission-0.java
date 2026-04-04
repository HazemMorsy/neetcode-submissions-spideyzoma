class Solution {
    public int rob(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dpLeft = new int[nums.length - 1];
        int[] dpRight = new int[nums.length - 1];
        dpLeft[0] = nums[0];
        dpLeft[1] = Math.max(nums[0], nums[1]);

        dpRight[0] = nums[1];
        dpRight[1] = Math.max(nums[1], nums[2]);
        for (int i=2;i<nums.length-1;i++) {
            dpLeft[i] = Math.max(dpLeft[i-1], nums[i] + dpLeft[i-2]);
        }
        System.out.println(Arrays.toString(dpLeft));

        for (int i=2;i<nums.length-1;i++) {
            dpRight[i] = Math.max(dpRight[i-1], nums[i+1] + dpRight[i-2]);
        }
        System.out.println(Arrays.toString(dpRight));

        return Math.max(dpLeft[nums.length-2], dpRight[nums.length-2]);
    }
}
