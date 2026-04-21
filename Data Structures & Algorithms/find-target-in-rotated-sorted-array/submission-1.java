class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        // at any time either left or right should be sorted (may be both)
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                return m;
            }

            if (nums[m] <= nums[r]) {
                // right is sorted
                if (target == nums[r]) {
                    return r;
                }
                else if (target > nums[m] && target < nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                // left is sorted
                if (target == nums[l]) {
                    return l;
                }
                else if (target < nums[m] && target > nums[l]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
            
        }

        return -1;
    }
}
