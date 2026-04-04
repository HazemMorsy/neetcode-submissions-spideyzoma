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
        Collections.sort(intervals, Comparator.comparingInt(i -> i.start));

        for (int i=1;i<intervals.size();i++) {
            int startOfNext = intervals.get(i).start;
            int endOfBefore = intervals.get(i-1).end;

            if (startOfNext < endOfBefore) {
                return false;
            }
        }
        return true;
    }
}
