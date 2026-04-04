class Solution {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {

        boolean[] visited = new boolean[nums.length];
        
        dfs(nums, visited, new ArrayList<>());

        return res;
    }

    void dfs(int[] nums, boolean[] visited, List<Integer> currList) {
        if (currList.size() == nums.length) {
            res.add(new ArrayList<>(currList));
        }

        for (int i=0;i<nums.length;i++) {
            if (!visited[i]) {
                currList.add(nums[i]);
                visited[i] = true;
                dfs(nums, visited, currList);
                visited[i] = false;
                currList.remove(currList.size()-1);
            }
        }


    }
}
