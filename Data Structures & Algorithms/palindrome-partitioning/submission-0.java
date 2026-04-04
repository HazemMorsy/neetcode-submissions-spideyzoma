class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        
        List<String> currRes = new ArrayList<>();
        
        dfs(s, currRes, 0);

        return res;
    }


    void dfs(String s, List<String> currRes, int i) {
        if (i == s.length()) {
            res.add(new ArrayList<>(currRes));
            return;
        }

        for (int j=i;j<s.length();j++) {
            if (isPlaindrome(s, i, j)) {
                currRes.add(s.substring(i, j+1));
                dfs(s, currRes, j+1);
                currRes.remove(currRes.size()-1);
            }
        }
    }


    boolean isPlaindrome(String s, int l, int r) {
       
        while(l<r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}
