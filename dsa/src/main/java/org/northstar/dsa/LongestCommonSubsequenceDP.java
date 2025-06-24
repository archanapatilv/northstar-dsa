package org.northstar.dsa;

public class LongestCommonSubsequenceDP {

    public static void main(String[] args) {
        // Test case 1: Regular case
        String S1 = "AGGTAB";
        String S2 = "GXTXAYB";
        System.out.println("Test Case 1 - Regular case: " + lcsDP(S1, S2));

        // Test case 2: Another regular case
        String text1 = "longest";
        String text2 = "stone";
        System.out.println("\nTest Case 2 - Another regular case: " + lcsDP(text1, text2));

        // Test case 3: Empty string
        System.out.println("\nTest Case 3 - Empty string: " + lcsDP("", "ABC"));

        // Test case 4: Both strings empty
        System.out.println("\nTest Case 4 - Both strings empty: " + lcsDP("", ""));

        // Test case 5: Single character strings
        System.out.println("\nTest Case 5 - Single character strings:");
        System.out.println("A and A: " + lcsDP("A", "A"));
        System.out.println("A and B: " + lcsDP("A", "B"));

        // Test case 6: No common subsequence
        System.out.println("\nTest Case 6 - No common subsequence: " + lcsDP("ABCD", "EFGH"));

        // Test case 7: Identical strings
        System.out.println("\nTest Case 7 - Identical strings: " + lcsDP("ABCD", "ABCD"));

        // Test case 8: One string is substring of another
        System.out.println("\nTest Case 8 - One string is substring of another: " + lcsDP("ABCD", "ABCDEF"));
    }

    public static int lcsDP(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        // Initializing a matrix of size (m+1)*(n+1)
        int[][] lcs = new int[m+1][n+1];

        // Building dp[m+1][n+1] in bottom-up fashion
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    lcs[i][j] = 1 + lcs[i-1][j-1];
                } else {
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }

        return lcs[m][n];
    }
}
