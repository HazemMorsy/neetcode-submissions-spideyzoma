class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int [] oneList = new int [matrix.length * matrix[0].length];
        int k = 0;
        for (int i=0;i<matrix.length;i++) {
            for (int j=0;j<matrix[i].length;j++) {
                oneList[k] = matrix[i][j];
                k++;
            }
        }


        int l = 0;
        int r = oneList.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (target == oneList[mid]) {
                return true;
            } else if (target < oneList[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return false;
    }
}
