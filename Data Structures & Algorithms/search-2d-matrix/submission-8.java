class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;


        int top = 0;
        int bottom = rows - 1;

        while (top <= bottom) {
            int m = top + (bottom - top) / 2;
            if (matrix[m][0] == target) {
                return true;
            } else if (matrix[m][0] > target) {
                bottom = m - 1;
            } else {
                if (target <= matrix[m][cols-1]) {
                    top = m;
                    break;
                } else {
                    top = m + 1;
                }
            }
        }

        int potentialRow = top;
        if (potentialRow == rows) {
            return false;
        }
        int left = 0;
        int right = cols - 1;
        while (left <= right) {
            int m = left + (right - left) / 2;
            if (matrix[potentialRow][m] == target) {
                return true;
            } else if (matrix[potentialRow][m] > target) {
                right = m - 1;
            } else {
                left = m + 1;
            }
        }

        return false;
    }
}
