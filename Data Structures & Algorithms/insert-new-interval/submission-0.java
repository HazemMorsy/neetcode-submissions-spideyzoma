class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        int newStart = newInterval[0];
        int newEnd = newInterval[1];

        int i = 0;
        while (i < intervals.length && newStart > intervals[i][1]) {
            result.add(intervals[i]);
            i++;
        }
        while (i < intervals.length && newEnd >= intervals[i][0]) {
            newStart = Math.min(newStart, intervals[i][0]);
            newEnd = Math.max(newEnd, intervals[i][1]);
            i++;
        }

        result.add(new int[]{newStart, newEnd});

        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][2]);



    }
}
