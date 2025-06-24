package org.northstar.dsa;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Time complexity O(m * n * 8l)
l -> depth of recursion
M*N: You start DFS from each cell.
8^L: Each DFS explores 8 directions up to depth L.

 */
public class WordBoggle {

    //reference
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    static int[] directionRow =    { 0, -1,  1, 0, -1, 1, -1, 1};
    static int[] directionColumn = {-1, -1, -1, 1,  1, 1,  0, 0};

    public static Set<String> findWords(List<String> words, char[][] matrix) {
        int[][] visited = new int[matrix.length][matrix[0].length];
        Set<String> result = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dfs(matrix, visited, result, words, i, j, new StringBuilder());
            }
        }
        return result;
    }

    private static void dfs(char[][] matrix, int[][] visited, Set<String> result,
                            List<String> words, int currentRow, int currentColumn, StringBuilder currentString) {
        visited[currentRow][currentColumn] = 1;
        currentString.append(matrix[currentRow][currentColumn]);
        if (words.contains(currentString.toString())) {
            result.add(currentString.toString());
        }
        for (int direction = 0 ; direction < directionRow.length; direction++) {
            int nextRow = currentRow + directionRow[direction];
            int nextCol = currentColumn + directionColumn[direction];
            if (canMove(matrix, visited, nextRow, nextCol)) {
                dfs(matrix, visited, result, words, nextRow, nextCol, currentString);
            }
        }
        visited[currentRow][currentColumn] = 0;
        currentString.deleteCharAt(currentString.length() - 1);
    }

    private static boolean canMove(char[][] matrix, int[][] visited,
                                   int nextRow, int nextCol) {
        return nextRow >= 0 && nextRow < matrix.length
                && nextCol >= 0 && nextCol < matrix[0].length
                && visited[nextRow][nextCol] == 0;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'G', 'I', 'Z'},
                {'U', 'E', 'K'},
                {'Q', 'S', 'E'}
        };

        List<String> dictionary = Arrays.asList("GEEKS", "FOR", "QUIZ", "GO");

        Set<String> foundWords = findWords(dictionary, board);
        System.out.println("Words found in boggle:");
        for (String word : foundWords) {
            System.out.println(word);
        }
    }
    int[] leftCharExists(char[][] matrix, int[][] visited, int n1, int m1, char character) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (m1 != 0 && visited[n1][m1 - 1] == 0 && matrix[n1][m1 - 1] == character) {
            return new int[]{n1, m1-1};
        }
        return null;
    }
    int[] leftUpCharExists(char[][] matrix, int[][] visited, int n1, int m1, char character) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (m1 != 0 && n1 != 0 && visited[n1-1][m1 - 1] == 0 && matrix[n1-1][m1 - 1] == character) {
            return new int[]{n1-1, m1-1};
        }
        return null;
    }
    int[] leftDownCharExists(char[][] matrix, int[][] visited, int n1, int m1, char character) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (m1 != 0 && n1 < n-1 && visited[n1+1][m1 - 1] == 0 && matrix[n1+1][m1 - 1] == character) {
            return new int[]{n1+1, m1-1};
        }
        return null;
    }

    int[] rightCharExists(char[][] matrix, int[][] visited, int n1, int m1, char character) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (m1 < m-1 && visited[n1][m1 + 1] == 0 && matrix[n1][m1+1] == character) {
            return new int[]{n1, m1+1};
        }
        return null;
    }
    int[] rightUpCharExists(char[][] matrix, int[][] visited, int n1, int m1, char character) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (m1 < m-1 && n1 != 0 && visited[n1-1][m1 + 1] == 0 && matrix[n1-1][m1+1] == character) {
            return new int[]{n1-1, m1+1};
        }
        return null;
    }
    int[] rightDownCharExists(char[][] matrix, int[][] visited, int n1, int m1, char character) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (m1 < m-1 && n1 < n- 1 && visited[n1+1][m1 + 1] == 0 && matrix[n1+1][m1+1] == character) {
            return new int[]{n1+1, m1+1};
        }
        return null;
    }

    int[] topCharExists(char[][] matrix, int[][] visited, int n1, int m1, char character) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (n1 != 0 && visited[n1-1][m1] == 0 && matrix[n1-1][m1] == character) {
            return new int[]{n1-1, m1};
        }
        return null;
    }
    int[] bottomCharExists(char[][] matrix, int[][] visited, int n1, int m1, char character) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (n1 < n-1 && visited[n1+1][m1] == 0 && matrix[n1+1][m1] == character) {
            return new int[]{n1+1, m1};
        }
        return null;
    }

}
