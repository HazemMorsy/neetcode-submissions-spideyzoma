class Solution {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i=0;i<nums2.length;i++) {
            map.put(nums2[i], map.getOrDefault(nums2[i], i));
        }

        int[] ans = new int[nums1.length];
        int index = 0;
        for (int num : nums1) {
            ans[index] = map.get(num); 
            index++;
        }

        return ans;
    }
}
