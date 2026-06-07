class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length;
        int COLS = heights[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (dfsPacific(heights, new boolean[ROWS][COLS], r, c, ROWS, COLS) && 
                    dfsAtlantic(heights, new boolean[ROWS][COLS], r, c, ROWS, COLS)) {
                    ans.add(new ArrayList(Arrays.asList(r, c)));
                }
            }
        }
        return ans;
    }

    private boolean dfsPacific(int[][] heights, boolean[][] visited, int r, int c, int ROWS, int COLS) {
        if (r == 0 || c == 0) {
            return true;
        }

        visited[r][c] = true;
        boolean res = false;

        if (r + 1 < ROWS && !visited[r+1][c] && heights[r+1][c] <= heights[r][c]) {
            res = res || dfsPacific(heights, visited, r+1, c, ROWS, COLS);
        }

        if (r - 1 >= 0 && !visited[r-1][c] && heights[r-1][c] <= heights[r][c]) {
            res = res || dfsPacific(heights, visited, r-1, c, ROWS, COLS);
        }

        if (c + 1 < COLS && !visited[r][c+1] && heights[r][c+1] <= heights[r][c]) {
            res = res || dfsPacific(heights, visited, r, c+1, ROWS, COLS);
        }

        if (c - 1 >= 0 && !visited[r][c-1] && heights[r][c-1] <= heights[r][c]) {
            res = res || dfsPacific(heights, visited, r, c-1, ROWS, COLS);
        }

        return res;
    }

    private boolean dfsAtlantic(int[][] heights, boolean[][] visited, int r, int c, int ROWS, int COLS) {
        if (r == ROWS - 1 || c == COLS - 1) {
            return true;
        }

        visited[r][c] = true;
        boolean res = false;

        if (r + 1 < ROWS && !visited[r+1][c] && heights[r+1][c] <= heights[r][c]) {
            res = res || dfsAtlantic(heights, visited, r+1, c, ROWS, COLS);
        }

        if (r - 1 >= 0 && !visited[r-1][c] && heights[r-1][c] <= heights[r][c]) {
            res = res || dfsAtlantic(heights, visited, r-1, c, ROWS, COLS);
        }

        if (c + 1 < COLS && !visited[r][c+1] && heights[r][c+1] <= heights[r][c]) {
            res = res || dfsAtlantic(heights, visited, r, c+1, ROWS, COLS);
        }

        if (c - 1 >= 0 && !visited[r][c-1] && heights[r][c-1] <= heights[r][c]) {
            res = res || dfsAtlantic(heights, visited, r, c-1, ROWS, COLS);
        }

        return res;
    }
}