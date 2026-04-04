class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> combination = new ArrayList<>();
        dfs(nums, target, 0, 0, combination);

        return res;
    }

    void dfs(int[] nums, int target, int currSum, int index, List<Integer> currCombination) {

         // we are off limits
        if (index == nums.length || currSum > target) {
            return;
        }

        // add a new combination
        if (currSum == target) {
            res.add(new ArrayList<>(currCombination));
            return;
        }

        // we still have chance for building the combination

        // first case : add the same number
        currCombination.add(nums[index]);
        dfs(nums, target, currSum + nums[index], index, currCombination);

        // second case : move to a new number
        currCombination.remove(currCombination.size() - 1);
        dfs(nums, target, currSum, index+1, currCombination);

    }




}
