class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[i].length;j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    max = Math.max(max, dfs(grid, visited, i ,j));
                }
            }
        }

        return max;
    }


    int dfs(int[][] grid, boolean[][] visited, int i, int j) {
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] == 0) {
            return 0;
        }

        if (visited[i][j]) {
            return 0;
        }

        visited[i][j] = true;
        return 1 + dfs(grid, visited, i+1, j) + dfs(grid, visited, i-1, j) + dfs(grid, visited, i, j+1) + dfs(grid, visited, i, j-1);
    }

}
