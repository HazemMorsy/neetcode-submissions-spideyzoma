class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board[i].length;j++) {
                if (dfs(board, word, visited, "", i,j)) {
                    return true;
                }
            }
        }

        return false;
    }


    boolean dfs(char[][] board, String word, boolean[][] visited, String currWord, int i, int j) {
        if (currWord.equals(word)) {
            return true;
        }

        if (currWord.length() == word.length() ||
        i < 0 ||
        i >= board.length ||
        j < 0 ||
        j >= board[0].length ||
        visited[i][j]) {
            return false;
        }

        visited[i][j] = true;
        currWord+= board[i][j];
        boolean res = dfs(board, word, visited, currWord, i+1, j) ||
        dfs(board, word, visited, currWord, i-1, j) ||
        dfs(board, word, visited, currWord, i, j+1) ||
        dfs(board, word, visited, currWord, i, j-1);

        visited[i][j] = false;
        currWord = currWord.substring(0, currWord.length() - 1);

        return res;
    }
}
