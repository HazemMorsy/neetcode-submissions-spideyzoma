class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> res = new HashSet<>();

        // freq for each element
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int i=0;i<nums.length;i++) {
            for (int j=i+1;j<nums.length;j++) {
                List<Integer> currRes = new ArrayList<>();
                int currSum = nums[i] + nums[j];
                int targetKey = currSum * -1;
                if (isValid(map, nums[i], nums[j], targetKey)) {
                    currRes.add(nums[i]);
                    currRes.add(nums[j]);
                    currRes.add(targetKey);
                    Collections.sort(currRes);
                    res.add(currRes);
                }
            }
        }

        return new ArrayList<>(res);
    }


    private boolean isValid(HashMap<Integer, Integer> map, int key1, int key2, int targetKey) {
        return map.containsKey(targetKey) 
        && (
            (key1 != key2 && key1 != targetKey && key2 != targetKey)
            || (key1 == key2 && key1 == targetKey && map.get(key1) > 2)
            || (key1 == targetKey && key2 != targetKey && map.get(key1) > 1)
            || (key2 == targetKey && key1 != targetKey && map.get(key2) > 1)
        );
    }
}
