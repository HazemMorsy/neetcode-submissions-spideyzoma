class Solution {
    // [1, -1 ,1, -1]
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int totalSum = 0;
        int res = 0;
        for (int num : nums) {
            totalSum += num;
            if (map.containsKey(totalSum - k)) {
                res += map.get(totalSum - k);
            }

            map.put(totalSum, map.getOrDefault(totalSum, 0) + 1);
        }


        return res;

    }
}