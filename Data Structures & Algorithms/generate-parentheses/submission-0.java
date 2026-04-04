class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs("", n, res);
        return res;
    }


    void dfs(String curr, int n, List<String> res) {

        if (curr.length() > n*2) {
            return;
        }

        if (curr.length() == n*2 && isValid(curr)) {
            res.add(curr);
            return;
        }

        dfs(curr + ")", n, res);
        dfs(curr + "(", n, res);
    }

    boolean isValid(String curr) {
        Stack<Character> stack = new Stack<>();
        for (char c : curr.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
