class Solution {
    public int leastInterval(char[] tasks, int n) {

        // ["A","A","A","B","C"]

        // A -> 3
        // B -> 1
        // C -> 1
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(new CustomComparator());
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(entry.getValue());
        }
        Queue<int[]> q = new LinkedList<>();
        int currTime = 0;

        while (!q.isEmpty() || !pq.isEmpty()) {
            if (!pq.isEmpty()) {
                int currMax = pq.poll();
                if (currMax - 1 > 0) {
                    q.add(new int[]{currMax-1, currTime + n});
                }
            } else {
                // idle case (no items in PQ so waiting for items in Q to be processed)
                currTime = q.peek()[1];
            }

            // items in queue should be added back to PQ if it is the time 
            if (!q.isEmpty() && q.peek()[1] <= currTime) {
                pq.offer(q.poll()[0]);
            }
            currTime++;

            
        }

        return currTime;

    }


    class CustomComparator implements Comparator<Integer> {
        @Override
        public int compare (Integer a, Integer b) {
            return b - a;
        }
    }
}
