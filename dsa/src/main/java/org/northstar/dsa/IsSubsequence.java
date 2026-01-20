package org.northstar.dsa;

/*
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string
 by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
Example 1:
Input: s = "abc", t = "ahbgdc"
Output: true

Example 2:
Input: s = "axc", t = "ahbgdc"
Output: false
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if(null == s || null == t
                || s.length() > t.length()) {
            return false;
        }
        if(s.length() == 0 || t.length() ==0 ) {
            return true;
        }
        int len = s.length();
        int tlen = t.length();
        int count = 0;
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < tlen; j++) {
                if(s.charAt(i) == t.charAt(j)) {
                    if(i < len-1) i++;
                    count++;
                }
            }
        }
        return count == len;
    }
}
