class Solution {
    public void setZeroes(int[][] matrix) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        boolean rowMarked = false;
        boolean colMarked = false;

        for (int i = 0;i < ROWS;i++) {
            for (int j = 0;j < COLS;j++) {
                if (matrix[i][j] == 0) {

                    if (i == 0) {
                        rowMarked = true;
                    } 

                    if (j == 0) {
                        colMarked = true;
                    }

                    // in [0,0] slot, we don't know which row or col to mark as zero
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }


        for (int i = 1;i<ROWS;i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0;j<COLS;j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 1;i<COLS;i++) {
            if (matrix[0][i] == 0) {
                for (int j = 0;j<ROWS;j++) {
                    matrix[j][i] = 0;
                }
            }
        }


        // now we need to handle the first row and col
        if (matrix[0][0] == 0) {

            if (rowMarked) {
                for (int i = 0;i<COLS;i++) {
                    matrix[0][i] = 0;
                }
            }

            if (colMarked) {
                for (int i = 0;i<ROWS;i++) {
                    matrix[i][0] = 0;
                }
            }

        }
    }
}
