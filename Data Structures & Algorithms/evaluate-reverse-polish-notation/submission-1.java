class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }

        Stack<String> s = new Stack<String>();
        HashSet<String> set = new HashSet<String>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");

        int total = 0;

        for (int i = 0;i<tokens.length;i++) {
            if (set.contains(tokens[i])) { // operator
               String secondNum = s.pop();
               String firstNum = s.pop();
               int second = Integer.parseInt(secondNum);
               int first = Integer.parseInt(firstNum);
               int res = 0;
               if (tokens[i].equals("+")) {
                res = first + second;

               } else if (tokens[i].equals("-")) {
                res = first - second;

               } else if (tokens[i].equals("*")) {
                res = first * second;

               } else {
                res = first / second;
               }

               s.push(Integer.toString(res));

               if (i == tokens.length -1) {
                total = res;
               }

            } else { // number
               s.push(tokens[i]);
            }
        }

        return total;
    }
}
