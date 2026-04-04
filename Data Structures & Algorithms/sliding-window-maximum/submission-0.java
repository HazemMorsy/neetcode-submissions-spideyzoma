class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k > nums.length) {
            return null;
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        // max heap
        PriorityQueue<Integer> pq = new 
        PriorityQueue<>((a, b) -> b - a);

        int l = 0;
        for (int i = 0;i < nums.length;i++) {
            pq.offer(nums[i]);
            if (pq.size() > k) {
                pq.remove(nums[l]);
                l++;
            }
            if (pq.size() == k) {
                res.add(pq.peek());
            }
        }

        int [] arrRes = new int [res.size()];

        for (int i=0;i<arrRes.length;i++) {
            arrRes[i] = res.get(i);
        }

        return arrRes;
    }
}
