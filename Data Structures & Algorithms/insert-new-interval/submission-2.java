class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res = new ArrayList<>();
        for (int i=0;i<intervals.length;i++) {
            if (newInterval == null || intervals[i][1] < newInterval[0]) {
                res.add(intervals[i]);
            } else if (intervals[i][0] > newInterval[1]) {
                res.add(newInterval);
                res.add(intervals[i]);
                newInterval = null;
            } else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }

        if (newInterval != null) {
            res.add(newInterval);
        }

        int [][] resArr = new int[res.size()][2];

        int idx = 0;
        for (int [] currArr : res) {
            resArr[idx++] = currArr;
        }

        return resArr;
    }
}
