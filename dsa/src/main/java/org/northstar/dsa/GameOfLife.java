package org.northstar.dsa;

import java.util.*;

public class GameOfLife {

    int[] rowNeighbors = new int[]{ 0, -1,  1, 0, -1, 1, -1, 1};
    int[] columnNeighbors = new int[]{-1, -1, -1, 1,  1, 1,  0, 0};
    static Map<Integer, Integer> replacementOfOld = new HashMap<>();
    static Map<Integer, Integer> replacementOfNew = new HashMap<>();
    static {

        replacementOfOld.put(0, 0);
        replacementOfOld.put(1, 1);
        replacementOfOld.put(2, 0);
        replacementOfOld.put(3, 1);

        replacementOfNew.put(0, 0);
        replacementOfNew.put(1, 0);
        replacementOfNew.put(2, 1);
        replacementOfNew.put(3, 1);
    }


    public void gameOfLife(int[][] board) {

        //  original      new         identifiedAs
        //    0           0               0
        //    1           0               1
        //    0           1               2
        //    1           1               3


        int m = board.length;
        int n = board[0].length;

        for(int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int nbrOfLiveNeighbors = getNbrOfLiveNeighbors(r, c, board, m, n);
                int val = board[r][c];
                int theOldVal = replacementOfOld.get(val);
                if(theOldVal == 1 && (nbrOfLiveNeighbors  < 2 || nbrOfLiveNeighbors > 3))
                    board[r][c] = 1;
                else if (theOldVal == 0 &&
                        nbrOfLiveNeighbors == 3) {
                    board[r][c] = 2;
                } else if (board[r][c] == 1) {
                    board[r][c] = 3;
                }
            }
        }

        for(int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                board[r][c] = replacementOfNew.get(board[r][c]);
            }
        }
    }

    private int getNbrOfLiveNeighbors(int row, int col, int[][] board, int m, int n) {
        int nbrOfLiveNeighbors = 0;

        for(int i =0; i < 8; i++) {
            int r = rowNeighbors[i]+row;
            int c = columnNeighbors[i]+col;
            if(isValidPosition(r, c, m, n)) {
                if(replacementOfOld.get(board[r][c]) == 1 || replacementOfOld.get(board[r][c]) == 3) {
                    nbrOfLiveNeighbors++;
                }
            }
        }
        return nbrOfLiveNeighbors;
    }

    private boolean isValidPosition(int row, int col, int m, int n) {
        if(row < 0 || row >= m) return false;
        if(col < 0 || col >= n) return false;
        return true;
    }

    public static void main(String[] args) {
        GameOfLife gol = new GameOfLife();
        gol.gameOfLife(new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}});
        System.out.println();
    }
}
