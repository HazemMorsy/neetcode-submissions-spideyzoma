class Solution {
    public int findMin(int[] nums) {
        int ans = nums[0];

        for (int num : nums) {
            if (num < ans) {
                ans = num;
                return ans;
            }
        }

        return ans;
    }
}
