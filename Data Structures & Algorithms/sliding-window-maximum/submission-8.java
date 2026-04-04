class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // we are moving to the right so whenver 
        // we are meeting a value higher than the current one, we need to keep it

        // we need to keep track of k elements at max at any time and with each step 
        // we have to add a number at the end and remove one in the begining 

        // Deque should be monotonically decreasing because we don't store values in ascending order 
        Deque<Integer> dq = new LinkedList<>();
        int [] res = new int[nums.length-k+1];
        int l = 0;
        int r = 0;
        while (r < nums.length) {
            while (!dq.isEmpty() && nums[r] > nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.add(r);

            // secure us from always keeping the first value in the begininning
            // we have two options 
            // 1) always advance left pointer on sliding the window
            // 2) we kept an index ahead of l in the first place
            if (dq.peekFirst() < l) {
                dq.pollFirst();
            }

            if (r - l + 1 == k) {
                res[l] = nums[dq.peekFirst()];
                l++;
            }

            r++;
        }

        return res;

    }
}
