class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int [] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();

        for (int i=0;i<temperatures.length;i++) {
            while(!stack.isEmpty() && stack.peek()[1] < temperatures[i]) {
                int [] temp = stack.pop();
                res[temp[0]] = i - temp[0];
            }
            stack.push(new int[]{i, temperatures[i]});
        }

        return res;
    }
}
