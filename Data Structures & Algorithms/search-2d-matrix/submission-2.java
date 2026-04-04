class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int [] colArr = new int[matrix.length];

        for (int i=0;i< matrix.length;i++) {
            colArr[i] = matrix[i][0];
        }

        int lCol = 0;
        int rCol = colArr.length - 1;
        while (lCol <= rCol) {
            int m = (lCol + rCol) / 2;

            if (colArr[m] == target) {
                return true;
            } else if (colArr[m] < target) {
                lCol = m + 1;
            } else {
                rCol = m - 1;
            }
        }

        int chosenRow = Math.min(lCol, rCol);
        if (chosenRow < 0) {
            return false;
        }

        // search in row corresponding to lCol/rcol
        int [] rowArr = matrix[chosenRow];

        int lRow = 0;
        int rRow = rowArr.length - 1;
        while (lRow <= rRow) {
            int m = (lRow + rRow) / 2;

            if (rowArr[m] == target) {
                return true;
            } else if (rowArr[m] < target) {
                lRow = m + 1;
            } else {
                rRow = m - 1;
            }
        }


        return false;



    }
}
