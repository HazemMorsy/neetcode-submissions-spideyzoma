class Solution {
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        boolean[][] visited = new boolean[ROWS][COLS];
        Queue<int[]> q = new LinkedList<>();

        int freshCells = 0;

        for (int i=0;i<ROWS;i++) {
            for (int j=0;j<COLS;j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i,j});
                }
                if (grid[i][j] == 1) {
                    freshCells++;
                }
            }
        }

        int res = 0;

        while (freshCells > 0 && !q.isEmpty()) {
            int currSize = q.size();
            for (int i=0;i<currSize;i++) {
                int[] curr = q.poll();
                int currI = curr[0];
                int currJ = curr[1];

                if (currI + 1 >= 0 && currI + 1 < ROWS && currJ >= 0 && currJ < COLS && !visited[currI + 1][currJ] && grid[currI + 1][currJ] == 1) {
                    q.add(new int[]{currI + 1, currJ});
                    visited[currI + 1][currJ] = true;
                    freshCells--;
                }
                
                if (currI - 1 >= 0 && currI - 1 < ROWS && currJ >= 0 && currJ < COLS && !visited[currI - 1][currJ] && grid[currI - 1][currJ] == 1) {
                    q.add(new int[]{currI - 1, currJ});
                    visited[currI - 1][currJ] = true;
                    freshCells--;
                }
                
                if (currI >= 0 && currI < ROWS && currJ + 1 >= 0 && currJ + 1 < COLS && !visited[currI][currJ + 1] && grid[currI][currJ + 1] == 1) {
                    q.add(new int[]{currI, currJ + 1});
                    visited[currI][currJ + 1] = true;
                    freshCells--;
                }

                if (currI >= 0 && currI < ROWS && currJ - 1 >= 0 && currJ - 1 < COLS && !visited[currI][currJ - 1] && grid[currI][currJ - 1] == 1) {
                    q.add(new int[]{currI, currJ - 1});
                    visited[currI][currJ - 1] = true;
                    freshCells--;
                }
            }

            res++;
        }

        return freshCells == 0 ? res : -1;
    }
}
