class Solution {
    public boolean canJump(int[] nums) {
        int target = nums.length-1;

        for (int i=nums.length - 2;i >= 0;i--) {
            if (nums[i] >= (target - i)) { // can jump
               target = i;
            }
        }

        if (target == 0) { // we can jump from the start
            return true;
        } 

        return false;
    }
}
