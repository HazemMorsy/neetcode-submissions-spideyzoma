class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // we are moving to the right so whenver 
        // we are meeting a value higher than the current one, we need to keep it

        // we need to keep track of k elements at max at any time and with each step 
        // we have to add a number at the end and remove one in the begining 

        // Deque should be monotonically decreasing because 
        Deque<Integer> dq = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        int l = 0;
        int r = 0;
        while (r < nums.length) {
            if (dq.isEmpty() || nums[r] <= nums[dq.peekLast()]) {
                dq.add(r);
            } else {
                while (!dq.isEmpty() && nums[r] > nums[dq.peekLast()]) {
                    dq.pollLast();
                }
                dq.add(r);
            }

            if (dq.peekFirst() < l) {
                dq.pollFirst();
            }

            if (r - l + 1 == k) {
                res.add(dq.peekFirst());
                l++;
            }

            r++;
        }

        int [] arrRes = new int [res.size()];

        for (int i=0;i<arrRes.length;i++) {
            arrRes[i] = nums[res.get(i)];
        }

        return arrRes;

    }
}
