class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> charsMap = new HashMap<>();
        charsMap.put(')', '(');
        charsMap.put(']', '[');
        charsMap.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for (int i = 0;i<s.length();i++) {
            char currChar = s.charAt(i);
            if (currChar == '{' || currChar == '[' || currChar == '(') {
                stack.push(currChar);
            } else {
                // closing bracket
                if (stack.isEmpty()) {
                    return false;
                }
                char topChar = stack.pop();
                if (charsMap.get(currChar) != topChar) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
