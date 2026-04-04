class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] start = new int[nums.length];
        int [] end = new int[nums.length];

        start[0] = nums[0];
        for (int i=1;i<nums.length;i++) {
            start[i] = nums[i] * start[i-1];
        }
        end[nums.length-1] = nums[nums.length-1];
        for (int i=nums.length-2;i>=0;i--) {
            end[i] = nums[i] * end[i+1];
        }

        int [] res = new int[nums.length];
        for (int i=0;i<nums.length;i++) {
            if (i ==0) {
                res[i] = end[i+1];
            }
            else if (i == nums.length-1) {
                res[i] = start[i-1];
            }
            else {
                res[i] = start[i-1] * end [i+1];
            }
        }

        return res;
    }
}  
