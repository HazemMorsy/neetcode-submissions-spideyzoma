class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        for (int i=0;i< nums.length;i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int l = i+1;
            int r = nums.length - 1;
            int currTarget = nums[i] * -1;
            while (l<r) {
                if (nums[l] + nums[r] == currTarget) {
                    List<Integer> currList = new LinkedList<>();
                    currList.add(nums[i]);
                    currList.add(nums[l]);
                    currList.add(nums[r]);
                    result.add(currList);
                    l++;
                    r--;
                    while(l<r && nums[l] == nums[l-1]) {
                        l++;
                    }
                } else if (nums[l] + nums[r] < currTarget) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        return result;
    }
}
