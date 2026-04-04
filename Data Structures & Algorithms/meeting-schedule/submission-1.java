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
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());
        for (int i=1;i<intervals.size();i++) {
            if (intervals.get(i).start < intervals.get(i-1).end) {
                return false;
            }
        }

        return true;
    }

    public class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval interval1, Interval interval2) {
            return interval1.start - interval2.start;
        }
    }
}
