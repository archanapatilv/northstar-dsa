package org.northstar.dsa;

public class ValidSudoku {

    public static  boolean isValidSudoku(char[][] board) {
        int[] rowMask = new int[9];
        int[] colMask = new int[9];
        int[] boxMask = new int[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;

                // 1 in binary, shift left by (c-'0') digit
                int bit = 1 << (c - '0');
                int box = (i / 3) * 3 + (j / 3);

                if ((rowMask[i] & bit) != 0 ||
                        (colMask[j] & bit) != 0 ||
                        (boxMask[box] & bit) != 0) {
                    return false;
                }

                rowMask[i] |= bit;
                colMask[j] |= bit;
                boxMask[box] |= bit;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'8','3','.','.','7','.','.','.','.'}
,{'6','.','.','1','9','5','.','.','.'}
,{'.','9','8','.','.','.','.','6','.'}
,{'8','.','.','.','6','.','.','.','3'}
,{'4','.','.','8','.','3','.','.','1'}
,{'7','.','.','.','2','.','.','.','6'}
,{'.','6','.','.','.','.','2','8','.'}
,{'.','.','.','4','1','9','.','.','5'}
,{'.','.','.','.','8','.','.','7','9'}};

        System.out.println(isValidSudoku(board));

    }
}
