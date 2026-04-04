class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }

        

        int maxSeq = 1;
        // only consider values that don't have the previous number
        for(int i=0;i<nums.length;i++) {
            int currMaxSeq = 1;
            if(!set.contains(nums[i]-1)) {
                int currNum = nums[i]+1;
                while(set.contains(currNum)) {

                    currNum++;
                    currMaxSeq +=1;
                }

            }
            maxSeq = Math.max(maxSeq, currMaxSeq);

        }

        return maxSeq;

    }
}
