package org.northstar.dsa;

import java.util.*;

public class RottingOranges {

    public static int orangesRotting(int[][] grid) {
        if(null == grid) {
            return -1;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int freshOrangesCount = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i =0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if(grid[i][j] == 1) {
                    freshOrangesCount++;
                }
            }
        }
        if(freshOrangesCount == 0) {
            return 0;
        }
        int minutesElapsed = 0;
        boolean isChangedToRotten = false;
        int[][] adjacentDirections = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        int currentSize = queue.size();
        int newSize = 0;
        while(!queue.isEmpty()) {
            int[] state = queue.poll();
            currentSize --;
            int row = state[0];
            int col = state[1];
            for(int[] dir: adjacentDirections) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if(newRow >= 0 && newRow < grid.length
                        && newCol >= 0 && newCol < grid[0].length) {
                    if(grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        freshOrangesCount--;
                        isChangedToRotten = true;
                        newSize++;
                        queue.add(new int[]{newRow, newCol});
                    }
                }
            }
            if(freshOrangesCount == 0) {
                if(currentSize != 0) return minutesElapsed+1;
                else return minutesElapsed;
            }
            if(isChangedToRotten && currentSize == 0) {
                minutesElapsed++;
                isChangedToRotten = false;
                currentSize = newSize;
                newSize = 0;

            }

        }
        return freshOrangesCount == 0 ?  minutesElapsed : -1;
    }

    public static void main(String[] args) {
        //System.out.println(orangesRotting(new int[][]{{2,1,1},{1,1,1},{0,1,2}}));
        System.out.println(orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
    }
}
