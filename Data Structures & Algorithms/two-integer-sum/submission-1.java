class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i=0;i<nums.length;i++) {
            if (!map.containsKey(nums[i])) {
                List<Integer> tempList = new LinkedList<>();
                tempList.add(i);
                map.put(nums[i], tempList);
            } else {
                List<Integer> currList = map.get(nums[i]);
                currList.add(i);
                map.put(nums[i], currList);
            }
        }

        for (int i=0;i<nums.length;i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = i;
                List<Integer> currList = map.get(target-nums[i]);
                res[1] = currList.get(currList.size()-1);

                if (res[0]!=res[1])
                break;
            }
        }

        return res;
    }
}
