package org.northstar.dsa;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EqualRowColumnPairsMatrix {
    static public int equalPairs(int[][] grid) {
        Set<List<Integer>> pairs = new HashSet<>();
        int rows = grid[0].length;
        int cols = grid.length;
        int[][] transposedMatrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposedMatrix[j][i] = grid[i][j];
            }
        }
        int count = 0;
        boolean found = false;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] != transposedMatrix[i][j]) {
                    found = false;
                    break;
                } else {
                    found = true;
                }
            }
            if(found) {
                count++;
                found = false;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{3,2,1},{1,7,6},{2,7,7}};
        System.out.print(equalPairs(grid));
    }
}
