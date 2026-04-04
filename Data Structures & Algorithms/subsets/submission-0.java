class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0, subset, res);
        return res;
    }

    void dfs(int[] nums, int index, List<Integer> subset, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[index]);
        dfs(nums, index+1, subset, res);
        // we only have one list for subset that keeps modified with each change so backtracking is required
        subset.remove(subset.size()-1);
        // increment the index still to reach the base case
        dfs(nums, index+1, subset, res);
    }
}
