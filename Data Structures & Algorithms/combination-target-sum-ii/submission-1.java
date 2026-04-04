class Solution {
    HashSet<List<Integer>> res = new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> combination = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, 0, combination);

        return new ArrayList<>(res);
    }

    void dfs(int[] nums, int target, int currSum, int index, List<Integer> currCombination) {

        // add a new combination
        if (currSum == target) {
            res.add(new ArrayList<>(currCombination));
            return;
        }

         // we are off limits
        if (index == nums.length || currSum > target) {
            return;
        }

        // we still have chance for building the combination

        // first case : add the new number in addition to the current
        currCombination.add(nums[index]);
        dfs(nums, target, currSum + nums[index], index+1, currCombination);

        // second case : move to a new number(ignoring the current)
        currCombination.remove(currCombination.size() - 1);
        dfs(nums, target, currSum, index+1, currCombination);
      

        

    }
}
