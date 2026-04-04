class Solution {
    public boolean isValidSudoku(char[][] board) {
        return isValidRows(board) && isValidCols(board) && isValidSquares(board);
    }

    private boolean isValidRows(char[][] board) {
        for(int i=0;i<9;i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j=0;j<9;j++) {
                if (board[i][j] != '.') {

                    if (set.contains(board[i][j])) {
                        return false;
                    }

                    set.add(board[i][j]);
                }
            }
        }
        return true;
    }


    private boolean isValidCols(char[][] board) {
        for(int i=0;i<9;i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j=0;j<9;j++) {
                if (board[j][i] != '.') {

                    if (set.contains(board[j][i])) {
                        return false;
                    }

                    set.add(board[j][i]);
                }
            }
        }
        return true;
    }

    private boolean isValidSquares(char[][] board) {
        for(int i=0;i<9;i+=3) {
            
            for (int j=0;j<9;j+=3) {
                HashSet<Character> set = new HashSet<>();
                for (int k=0;k<3;k++) {
                    for (int l=0;l<3;l++) {
                        if(board[i+k][j+l] != '.') {

                            if(set.contains(board[i+k][j+l])) {
                                return false;
                            }

                            set.add(board[i+k][j+l]);

                        }
                    }
                }
            }
        }
        return true;
    }
}
