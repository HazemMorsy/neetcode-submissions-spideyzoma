class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        int rows = board.length;
        int cols = board[0].length;

        for (String word : words) {
            boolean[][] visited = new boolean[rows][cols];
            boolean wordAdded = false;
            for (int i=0;i<rows;i++) {
                for (int j=0;j<cols;j++) {
                    if (dfs(i, j, rows, cols, board, visited, word, 0)) {
                        ans.add(word);
                        wordAdded = true;
                    }
                    if (wordAdded) {
                        break;
                    }
                }
                if (wordAdded) {
                    break;
                }
            }
        }

        return ans;
    }


    boolean dfs(int i, int j, int rows, int cols, char[][] board, boolean[][] visited, String word, int iWord) {
        if (iWord >= word.length()) {
            return true;
        }
        
        if (i < 0 || i >= rows || j < 0 || j >= cols || visited[i][j]
        || board[i][j] != word.charAt(iWord)) {
            return false;
        }

        boolean res = false;
        visited[i][j] = true;
        res = dfs(i+1, j, rows, cols, board, visited, word, iWord+1) 
            || dfs(i-1, j, rows, cols, board, visited, word, iWord+1)
            || dfs(i, j+1, rows, cols, board, visited, word, iWord+1)
            || dfs(i, j-1, rows, cols, board, visited, word, iWord+1);
        visited[i][j] = false;

        return res;
    }

}
