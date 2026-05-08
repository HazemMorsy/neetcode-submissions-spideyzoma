class MedianFinder {

    // [1,2,3,4]

    // maxheap : [1,2]. minheap : [4]

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(new CustomComparator());
        minHeap = new PriorityQueue<>();
    }

    // [-1,-2,-3,-4,-5]

    // maxHeap : [-1] , minHeap : []
    // maxHeap : [-2] , minHeap: [-1]

    
    public void addNum(int num) {
        if (maxHeap.size() == minHeap.size()) {
            if (maxHeap.isEmpty() || num <= minHeap.peek()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
                maxHeap.offer(minHeap.poll());
            }
        } else {
            if (num >= maxHeap.peek()) {
                minHeap.offer(num);
            } else {
                maxHeap.offer(num);
                minHeap.offer(maxHeap.poll());
            }

        }
    }
    
    public double findMedian() {
        int totalSize = maxHeap.size() + minHeap.size();

        if (totalSize % 2 == 0) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }

    public class CustomComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            return b - a;
        }
    }
}
