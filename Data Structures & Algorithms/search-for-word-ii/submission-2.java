class Solution {
    class TrieNode {
        HashMap<Character, TrieNode> children;
        boolean end;

        public TrieNode() {
            children = new HashMap<>();
            end = false;
        }


        public void addWord(String word) {
            TrieNode curr = this;
            for (char c : word.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new TrieNode());
                }
                curr = curr.children.get(c);
            }
            curr.end = true;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        HashSet<String> ans = new HashSet<>();
        int rows = board.length;
        int cols = board[0].length;

        TrieNode root = new TrieNode();
        for (String word : words) {
            root.addWord(word);
        }

        boolean [][] visited = new boolean[rows][cols];
        for (int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                dfs(i, j, rows, cols, board, visited, root, "", ans);
            }
        }

        return new ArrayList<>(ans);

    }

    void dfs(int i, int j, int rows, int cols, char[][] board, boolean[][] visited, TrieNode root, String currStr, HashSet<String> ans) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || visited[i][j] || !root.children.containsKey(board[i][j])) {
            return;
        }

        currStr += board[i][j];
        visited[i][j] = true;
        TrieNode child = root.children.get(board[i][j]);
        if (child.end) {
            ans.add(currStr);
        }
        
        dfs(i+1, j, rows, cols, board, visited, child, currStr, ans);
        dfs(i-1, j, rows, cols, board, visited, child, currStr, ans);
        dfs(i, j+1, rows, cols, board, visited, child, currStr, ans);
        dfs(i, j-1, rows, cols, board, visited, child, currStr, ans);
        visited[i][j] = false;
    }

}
