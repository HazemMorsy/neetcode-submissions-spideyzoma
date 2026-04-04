class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals , new IntervalComparator());
        ArrayList<int[]> res = new ArrayList<>();

        int i = 0;
        res.add(intervals[i]);

        while (i < intervals.length) {
            if (intervals[i][0] > res.get(res.size()-1)[1]) {
                res.add(intervals[i]);
            } else {
                // overlapping case
                int[] oldInterval = res.get(res.size()-1);
                int[] newInterval = intervals[i];
                res.set(res.size()-1, new int[]{oldInterval[0], Math.max(oldInterval[1], newInterval[1])});
            }
            i++;
        }

        return res.toArray(new int[res.size()][]);


    }


    class IntervalComparator implements Comparator<int[]> {

        public int compare (int[] interval1, int[] interval2) {
            if (interval1[0] == interval2[0]) {
                return interval1[1] - interval2[1];
            }

            return interval1[0] - interval2[0];
        }
    }
}
