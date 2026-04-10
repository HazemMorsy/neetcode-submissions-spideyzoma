class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        HashSet<String> ops = new HashSet<>();
        ops.add("+");
        ops.add("-");
        ops.add("*");
        ops.add("/");

        for (String token : tokens) {
            if (ops.contains(token)) {
                int sec = stack.pop();
                int first = stack.pop();
                stack.push(calc(first, sec, token));
            } else {
                // number
                stack.push(Integer.valueOf(token));
            }
        }

        return Integer.valueOf(stack.pop());
    }


    private int calc(int first, int second, String token) {
        if (token.equals("+")) {
            return first + second;
        } else if (token.equals("-")) {
            return first - second;
        } else if (token.equals("*")) {
            return first * second;
        } else {
            return first / second;
        }
    }
}
