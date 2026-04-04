/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (Interval interval : intervals) {
            // meeting room is busy
            if (pq.isEmpty() || interval.start < pq.peek()) {
                pq.offer(interval.end);
            } else {
                pq.poll();
                pq.offer(interval.end);
            }
        }

        return pq.size();

    }


    class IntervalComparator implements Comparator<Interval> {
        public int compare (Interval interval1, Interval interval2) {
            return interval1.start - interval2.start;
        }
    }
}
