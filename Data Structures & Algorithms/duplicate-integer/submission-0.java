class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> storage = new HashSet<Integer>();
        for (int num : nums) {
            if (storage.contains(num)) {
                return true;
            }
            storage.add(num);
        }
        return false;
    }
}
