class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        // check horizontally 
        for (int i=0;i<9;i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j=0;j<9;j++) {
                if (board[i][j] != '.') {
                    if (set.contains(board[i][j])) {
                        return false;
                    } else {
                        set.add(board[i][j]);
                    }
                }
            }
        }


        // check vertically 
        for (int i=0;i<9;i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j=0;j<9;j++) {
                if (board[j][i] != '.') {
                    if (set.contains(board[j][i])) {
                        return false;
                    } else {
                        set.add(board[j][i]);
                    }
                }
            }
        }

        // check boxes
        for (int g=0;g<9;g++) {
            HashSet<Character> set = new HashSet<>();
            for (int i=0;i<3;i++) {
                for (int j=0;j<3;j++) {
                    int r = i + (g / 3) * 3;
                    int c = j + (g % 3) * 3;
                    if (board[r][c] != '.') {
                    if (set.contains(board[r][c])) {
                        return false;
                    } else {
                        set.add(board[r][c]);
                    }
                }

                }
            }
        }



        return true;

    }
}
