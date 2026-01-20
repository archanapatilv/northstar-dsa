package org.northstar.dsa;

public class IndexOfFirstOccurrenceInAString {
    public int _strStr(String haystack, String needle) {
        int h = haystack.length();
        int n = needle.length();
        if(n > h) return -1;
        int i = 0, j = 0;
        boolean found = false;
        while(i < h && j < n) {
            if(needle.charAt(j) != haystack.charAt(i)) {
                i++;
                j = 0;
            } else if(j == n - 1){
                found = true;
                break;
            } else {
                i++;
                j++;
            }
        }
        return found ? i - (n - 1) : -1;

    }

    public int strStr(String haystack, String needle) {
        int h = haystack.length();
        int n = needle.length();
        if(n > h ) return -1;
        if(n == 0) return n;
        int i = 0, j = 0;
        for(; i < h - n + 1; i++) {
            if(haystack.substring(i, i+n).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //int n = new IndexOfFirstOccurrenceInAString().strStr("sadbutsad", "sad");
        //System.out.println(n);
        //hello, ll
        //mississippi, a
        //mississippi, issip
        int n = new IndexOfFirstOccurrenceInAString().strStr("hello", "ll");
        System.out.println(n);
    }
}
