class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // key point is that if we have a non incereasing array then 
        // we know that the first element that breaks the sequence can indicate 
        // that it can be used to start couning the warmer days

        int [] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<temperatures.length;i++) {

            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int currIdx = stack.pop();
                res[currIdx] = i - currIdx;
            }
            stack.push(i);
        }

        return res;
    }
}
