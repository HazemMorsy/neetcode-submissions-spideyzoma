class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : stones) {
            // max heap
            pq.add(n * -1);
        }
        while(pq.size() > 1){
            int topMax = pq.poll();
            int top2Max = pq.poll();
            int newStone = topMax - top2Max;
            if (newStone !=0) {
                pq.add(newStone);
            }
        }
        return pq.isEmpty()? 0 : pq.poll() * -1;
    }
}
