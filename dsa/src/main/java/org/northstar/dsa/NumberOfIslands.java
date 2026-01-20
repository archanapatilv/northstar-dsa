package org.northstar.dsa;

import java.util.LinkedList;
import java.util.Queue;


public class NumberOfIslands {

    public static int numIslands(char[][] grid) {
            if(null == grid || 0 == grid.length) {
                return 0;
            }
            int count = 0;
            int rows = grid.length;
            int columns = grid[0].length;
            for(int row = 0; row < rows; row++) {
                for (int column = 0; column < columns; column++) {
                    if(grid[row][column] == '1') {
                        count++;
                        grid[row][column] = '0';
                        //BFS
                        Queue<Integer> adjacents = new LinkedList<>();
                        adjacents.add(row * columns + column);
                        while(!adjacents.isEmpty()) {
                            int val = adjacents.remove();
                            int r = val / columns;
                            int c = val % columns;
                            //left
                            if(c-1 >= 0 && grid[r][c-1] == '1') {
                                adjacents.add(r*columns+(c-1));
                                grid[r][c-1] = '0';
                            }
                            //right
                            if(c+1 < columns && grid[r][c+1] == '1') {
                                adjacents.add(r*columns+(c+1));
                                grid[r][c+1] = '0';
                            }
                            //top
                            if(r-1 >= 0 && grid[r-1][c] == '1') {
                                adjacents.add((r-1)*columns+(c));
                                grid[r-1][c] = '0';
                            }
                            //Bottom
                            if(r+1 < rows && grid[r+1][c] == '1') {
                                adjacents.add((r+1)*columns+(c));
                                grid[r+1][c] = '0';
                            }
                        }
                    }
                }
            }
            return count;
    }
    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        char[][] grid1 = {
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}
        };
        System.out.println(numIslands(grid1));
    }

}
