class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for (int[] interval : intervals) {
            int currEnd = res.get(res.size()-1)[1];

            if (interval[0] <= currEnd) { // indication of overlapping
                res.get(res.size()-1)[1] = Math.max(interval[1], currEnd);
            } else {
                res.add(new int[]{interval[0], interval[1]});
            }

        }

        return res.toArray(new int[res.size()][2]);

    }
}
