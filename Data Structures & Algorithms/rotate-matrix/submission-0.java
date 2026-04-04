class Solution {
    public void rotate(int[][] matrix) {

        // first step swap the rows 
        int matrixLen = matrix[0].length;
        int swapLen = matrixLen/2;
        for (int i=0;i<swapLen;i++) {
            for (int col=0;col<matrixLen;col++) {
                int temp = matrix[i][col];
                matrix[i][col] = matrix[matrixLen-1-i][col];
                matrix[matrixLen-1-i][col] = temp;
            }
        }

        // second step transpose (swap rows with cols)
        for (int i=0;i<matrixLen;i++) {
            for (int col=0;col<matrixLen;col++) {
                if (col > i) {
                    break;
                }

                int temp = matrix[i][col];
                matrix[i][col] = matrix[col][i];
                matrix[col][i] = temp;
            }
        }

    }
}
