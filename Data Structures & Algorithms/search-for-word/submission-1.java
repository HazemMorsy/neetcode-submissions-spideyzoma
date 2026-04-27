class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean [][] visited = new boolean[rows][cols];
        for (int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                if (dfs(i, j, board, visited, 0, word, rows, cols)) {
                    return true;
                }
            }
        }

        return false;
    }


    private boolean dfs (int i, int j, char[][] board, boolean[][] visited, int iWord, String word, int rows, int cols) {
        if (iWord >= word.length()) {
            return true;
        }
        if (i < 0 || i >= rows || j < 0 || j >= cols || visited[i][j]) {
            return false;
        }
        boolean ans = false;
        if (board[i][j] == word.charAt(iWord)) {
            visited[i][j] = true;
            ans = dfs(i+1, j, board, visited, iWord+1, word, rows, cols)
            || dfs(i-1, j, board, visited, iWord+1, word, rows, cols)
            || dfs(i, j+1, board, visited, iWord+1, word, rows, cols)
            || dfs(i, j-1, board, visited, iWord+1, word, rows, cols);
            visited[i][j] = false;
            
        }

        return ans;


    }
}
