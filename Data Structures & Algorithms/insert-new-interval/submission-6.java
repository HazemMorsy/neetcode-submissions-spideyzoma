class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res = new ArrayList<>();

        int i = 0;
        // intervals less than the boundary of the new interval
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        // simpler approach
        // and actually we dont need that newInterval[0] <= intervals[i][1] as it is implicitly achieved by the above condition
        while (i < intervals.length && 
            newInterval[1] >= intervals[i][0] && newInterval[0] <= intervals[i][1]
         ) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        res.add(newInterval);

        while (i < intervals.length && intervals[i][0] > newInterval[1]) {
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[res.size()][]);
    }
}
