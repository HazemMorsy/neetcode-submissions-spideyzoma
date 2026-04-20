class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int res = nums[0];

        while (l <= r) {
            if (nums[l] <= nums[r]) {
                // sorted array
                res = Math.min(res, nums[l]);
                break;
            }

            int m = l + (r - l) / 2;
            if (nums[m] >= nums[l]) {
                l = m + 1;
            } else {
                res = Math.min(res, nums[m]);
                r = m - 1;
            }
        }

        return res;
    }
}
