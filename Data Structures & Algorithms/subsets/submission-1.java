class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> sub = new LinkedList<>();
        dfs(nums, 0, ans, sub);
        return ans;
    }

    public void dfs(int[] nums, int idx, List<List<Integer>> ans, List<Integer> sub) {

        if (idx == nums.length) {
            ans.add(new ArrayList<>(sub));
            return;
        }

        // add
        sub.add(nums[idx]);
        dfs(nums, idx+1, ans, sub);

        // remove
        sub.remove(sub.size()-1);
        dfs(nums, idx+1, ans, sub);

    }
}
