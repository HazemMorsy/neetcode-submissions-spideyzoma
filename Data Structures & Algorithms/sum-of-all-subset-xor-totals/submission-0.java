class Solution {

    int res = 0;
    public int subsetXORSum(int[] nums) {
        backtrack(nums, 0, new ArrayList<>());
        return res;
    }


    private void backtrack(int[] nums, int i, List<Integer> subset) {
        int temp = 0;
        for (int num : subset) {
            temp ^= num;
        }

        res+= temp;


        for (int idx = i;idx<nums.length;idx++) {
            subset.add(nums[idx]);
            backtrack(nums, idx+1, subset);
            subset.remove(subset.size()-1);
        }
    }
}