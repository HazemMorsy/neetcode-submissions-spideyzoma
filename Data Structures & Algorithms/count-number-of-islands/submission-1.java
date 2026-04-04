class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[i].length;j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, grid.length, j, grid[i].length);
                    count++;
                }
            }
        }

        return count;
    }


    private void dfs (char[][] grid, int i, int rows, int j, int cols) {
        if (i < 0 || i == rows || j < 0 || j == cols) {
            return;
        }

        if (grid[i][j] != '1') {
            return;
        }

        grid[i][j] = '0';

        dfs(grid, i + 1, rows, j, cols);
        dfs(grid, i - 1, rows, j, cols);
        dfs(grid, i, rows, j + 1, cols);
        dfs(grid, i, rows, j - 1, cols);
    }
}
