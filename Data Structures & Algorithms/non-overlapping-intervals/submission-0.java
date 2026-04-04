class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Arrays.sort(intervals, new IntervalComparator());
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]> res = new ArrayList<>();

        res.add(intervals[0]);
        int intervalsRemoved = 0;

        int i = 0;
        while (i < intervals.length) {
            if (intervals[i][0] >= res.get(res.size()-1)[1]) {
                res.add(intervals[i]);
            } else {
                // we only have to keep the min value to give chance for not ovelapping later on
                res.get(res.size()-1)[1] = Math.min(intervals[i][1], res.get(res.size()-1)[1]);
                intervalsRemoved++;
            }   
            i++;  
        }

        return intervalsRemoved-1;
    }    
}
