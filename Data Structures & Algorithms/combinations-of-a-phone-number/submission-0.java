class Solution {

    

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (digits.length() == 0) {
            return res;
        }

        HashMap<Character, List<Character>> map = new HashMap<>();
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));

        dfs(res, digits, 0, "", map);
        return res;
    }


    void dfs(List<String> res, String digits, int i, String curr, HashMap<Character, List<Character>> map) {
        if (curr.length() == digits.length()) {
            res.add(curr);
            return;
        }

        List<Character> arrList = map.get(digits.charAt(i));

        for (char c : arrList) {
            dfs(res, digits, i+1, curr+c, map);
        }

    }






}
