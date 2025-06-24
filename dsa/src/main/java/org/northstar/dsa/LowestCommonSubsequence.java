package org.northstar.dsa;

import java.util.Arrays;

public class LowestCommonSubsequence {

    static int[][] RESULT = new int[3][5];
    public static void main(String[] args) {
        char[] a = {'b', 'd'};
        char[] b = {'a', 'b', 'c', 'd'};
       // int lcs = lcs(0, 0, a, b);
        LCS lcs = lcs(0, 0, a, b, new LCS(0, ""));
        String text = lcsText(0, 0, a, b, "");
        System.out.println("The longest common subsequence length is :" + text);


        //DP
        lcsDP(0, 0, 1, 1, a, b);
        System.out.println(RESULT);
    }

    public static void lcsDP(int i, int j, int x, int y, char[] a, char[] b) {
        if(a[i] == b[j]) {
            RESULT[x][y] = 1 + RESULT[x-1][y-1];
        } else {
            RESULT[x][y] = Math.max(RESULT[x-1][y], RESULT[x][y-1]);
        }
    }

    public static int lcs(int i, int j, char[] a, char[] b) {
        if(i >= a.length || j >= b.length) {
            return 0;
        } else if (a[i] == b[j]) {
            return 1 + lcs(i+1, j+1, a , b);
        } else {
            return Math.max(lcs(i+1, j, a, b), lcs(i, j+1, a, b));
        }
    }

    public static String lcsText(int i, int j, char[] a, char[] b, String text) {
        String temp = text;
        if(i >= a.length || j >= b.length) {
            return "";
        } else if (a[i] == b[j]) {
            return temp + a[i] + lcsText(i+1, j+1, a , b, temp);
        } else {
            String a1 = lcsText(i+1, j, a, b, temp);
            String b1 = lcsText(i, j+1, a, b, temp);
            if(a1.length() >= b1.length()) {
                return a1;
            }
            return b1;
        }
    }

    public static LCS lcs(int i, int j, char[] a, char[] b, LCS lcs) {
        LCS temp = LCS.copy(lcs);
        if(i >= a.length || j >= b.length) {
            return temp;
        } else if (a[i] == b[j]) {
            temp.text = temp.text + a[i];
            temp.value += 1;
            return lcs(i+1, j+1, a , b, temp);
        } else {
            return LCS.max(lcs(i+1, j, a, b, temp), lcs(i, j+1, a, b, temp));
        }
    }
}

class LCS {
    int value;
    String text;

    public LCS(int value, String text) {
        this.value = value;
        this.text = text;
    }

    static LCS max(LCS a, LCS b) {
        if (a.value >= b.value) {
            return a;
        } else {
            return b;
        }
    }

    static LCS copy(LCS from) {
        return new LCS(from.value, from.text);
    }
}