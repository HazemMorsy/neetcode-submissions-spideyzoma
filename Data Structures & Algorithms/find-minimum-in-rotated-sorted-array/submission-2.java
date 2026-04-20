class Solution {
    // [6, 1, 2, 3 ,4, 5]
    // [2, 3, 4, 0, 1]
    public int findMin(int[] nums) {
        int len = nums.length;
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[(m - 1 + len) % len] >= nums[m]) {
                return nums[m];
            }

            if (nums[r] <= nums[m]) {
                l = m + 1;
            } else {
                r = m;
            }

        }

        return -1;
    }
}
