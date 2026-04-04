class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new IntervalComparator());

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int [] res = new int[pq.size()];
        for (int i=0;i<res.length;i++) {
            res[i] = pq.poll()[0];
        }

        return res;


    }


    class IntervalComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            return a[1] - b[1];
        }
    }
}
