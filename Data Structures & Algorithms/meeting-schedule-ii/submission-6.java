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
        int [] start = new int[intervals.size()];
        int [] end = new int[intervals.size()];
        int idx = 0;
        for (Interval interval : intervals) {
            start[idx] = interval.start;
            end[idx] = interval.end;
            idx++;
        }

        Arrays.sort(start);
        Arrays.sort(end);


        int startIdx = 0;
        int endIdx = 0;
        int res = 0;
        int maxCount = 0;

        while (startIdx < intervals.size()) {
            if (start[startIdx] < end[endIdx]) {
                startIdx++;
                maxCount++;
            } else {
                endIdx++;
                maxCount--;
            }
            res = Math.max(res, maxCount);

        }

        return res;
        

    }
}
