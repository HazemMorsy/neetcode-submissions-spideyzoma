class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // [-4, -1, -1, 0, 1, 2]
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0;i<nums.length;i++) {

            if (i != 0 && nums[i] == nums[i-1]) {
                continue;
            }

            List<Integer> currRes = new ArrayList<>();
            int targetSum = nums[i] * -1;
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int currSum = nums[l] + nums[r];
                if (currSum == targetSum) {
                    currRes.add(nums[i]);
                    currRes.add(nums[l]);
                    currRes.add(nums[r]);

                    res.add(currRes);
                    l++;
                    while (l < nums.length && nums[l] == nums[l-1]) {
                        l++;
                    }

                    r--;
                    // while (r >= 0 && nums[r] == nums[r+1]) {
                    //     r--;
                    // }
                    currRes = new ArrayList<>();

                } else if (currSum > targetSum) {
                    r--;
                } else {
                    l++;
                }
            }
        }

        return res;
    }
}
