class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();
        int firstRow = 0;
        int lastRow = matrix.length;

        int firstCol = 0;
        int lastCol = matrix[0].length;


        while(firstRow < lastRow && firstCol < lastCol) {

            for (int i =firstCol;i<lastCol;i++) {
                res.add(matrix[firstRow][i]);
            }

            for (int i=firstRow+1;i<lastRow;i++) {
                res.add(matrix[i][lastCol-1]);
            }

            if (firstRow == lastRow-1 || firstCol == lastCol-1) {
                break;
            }

            for (int i=lastCol-2;i>=firstCol;i--) {
                res.add(matrix[lastRow-1][i]);
            }

            for (int i=lastRow-2;i>firstRow;i--) {
                res.add(matrix[i][firstCol]);
            }

            firstRow++;
            firstCol++;
            lastRow--;
            lastCol--;
        }

        return res;

    }
}
