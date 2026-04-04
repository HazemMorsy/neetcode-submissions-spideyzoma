class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new IntervalComparator());

        int[][] pointsDistance = new int[points.length][3];
        for (int i=0;i<points.length;i++) {
            pointsDistance[i][0] = points[i][0];
            pointsDistance[i][1] = points[i][1];
            pointsDistance[i][2] = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            pq.offer(pointsDistance[i]);
        }
        int [][] res = new int[k][2];
        for (int i=0;i<k;i++) {
            int[] currPoint = pq.poll();
            res[i][0] = currPoint[0];
            res[i][1] = currPoint[1];
        }

        return res;
    }


    public class IntervalComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return a[2] - b[2];
        }
    }
}
