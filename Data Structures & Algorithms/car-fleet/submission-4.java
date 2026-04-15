class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int len = position.length;
        int [][] merged = new int[len][2];

        for (int i=0;i<len;i++) {
            merged[i][0] = position[i];
            merged[i][1] = speed[i];
        }

        Arrays.sort(merged, new ArrComparator());

        // 7,1. 4,2. 1,2. 0,1  , destination = 12
        //t=5,  4,   5.5, 12

        // 8,2. 6,3.  , destination = 10
        //t=1,  1.333

        double [] ts = new double[len];
        for (int i=0;i<len;i++) {
            ts[i] = (target - merged[i][0]) / (merged[i][1] * 1.0);
        }

        Stack<Double> stack = new Stack<>();
        for (int i = 0;i < len;i++) {
            while (stack.isEmpty() || ts[i] > stack.peek()) {
                stack.push(ts[i]);
            }
        }
    
        return stack.size();

    }

    class ArrComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            return b[0] - a[0];
        }
    }
}

