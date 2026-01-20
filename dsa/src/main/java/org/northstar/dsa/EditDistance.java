package org.northstar.dsa;

import java.util.Arrays;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] d: dp) {
            Arrays.fill(d, -1);
        }
        return _minDistance(n-1, m-1, word1, word2, dp);
    }

    private int _minDistance(int i, int j, String word1, String word2, int[][] dp) {
        if( i < 0) return j + 1;
        if(j < 0) return i + 1;
        if(dp[i][j] != -1) return dp[i][j];
        if(word1.charAt(i) == word2.charAt(j)) {
            dp[i][j] = _minDistance(i - 1, j - 1, word1, word2, dp);
            return dp[i][j];
        }
        else {
            dp[i][j] = 1+ Math.min(Math.min(
                            _minDistance(i, j-1, word1, word2, dp), //insert
                            _minDistance(i-1, j, word1, word2, dp)), //delete
                    _minDistance(i-1, j-1, word1, word2, dp));
            return dp[i][j];
        }
    }

    public static void main(String[] args) {
        EditDistance ed = new EditDistance();
        int x = ed.minDistance("horse", "ros");
        System.out.println(x);
    }
}
