package org.northstar.dsa;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LongestCommonSubsequenceDPTest {

    @Test
    public void testRegularCase() {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        assertEquals(4, LongestCommonSubsequenceDP.lcsDP(s1, s2));
    }

    @Test
    public void testAnotherRegularCase() {
        String text1 = "longest";
        String text2 = "stone";
        assertEquals(3, LongestCommonSubsequenceDP.lcsDP(text1, text2));
    }

    @Test
    public void testEmptyString() {
        assertEquals(0, LongestCommonSubsequenceDP.lcsDP("", "ABC"));
        assertEquals(0, LongestCommonSubsequenceDP.lcsDP("ABC", ""));
    }

    @Test
    public void testBothStringsEmpty() {
        assertEquals(0, LongestCommonSubsequenceDP.lcsDP("", ""));
    }

    @Test
    public void testSingleCharacterStrings() {
        assertEquals(1, LongestCommonSubsequenceDP.lcsDP("A", "A"));
        assertEquals(0, LongestCommonSubsequenceDP.lcsDP("A", "B"));
    }

    @Test
    public void testNoCommonSubsequence() {
        assertEquals(0, LongestCommonSubsequenceDP.lcsDP("ABCD", "EFGH"));
    }

    @Test
    public void testIdenticalStrings() {
        assertEquals(4, LongestCommonSubsequenceDP.lcsDP("ABCD", "ABCD"));
    }

    @Test
    public void testOneStringIsSubstring() {
        assertEquals(4, LongestCommonSubsequenceDP.lcsDP("ABCD", "ABCDEF"));
        assertEquals(4, LongestCommonSubsequenceDP.lcsDP("ABCDEF", "ABCD"));
    }

    @Test
    public void testSpecialCharacters() {
        assertEquals(3, LongestCommonSubsequenceDP.lcsDP("A@B#C", "X@Y#Z"));
    }

    @Test
    public void testLongStrings() {
        String s1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String s2 = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
        assertEquals(1, LongestCommonSubsequenceDP.lcsDP(s1, s2));
    }
} 