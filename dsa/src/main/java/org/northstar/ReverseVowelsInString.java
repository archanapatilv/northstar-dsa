package org.northstar;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsInString {
    public static String reverseVowels(String s) {
        if(null == s || s.isBlank()) {
            return "";
        }
        if(1 == s.length()) {
            return s;
        }
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        char[] sArr = s.toCharArray();
        int l = sArr.length;
        int start = 0;
        int end = l -1;
        while(start < end) {
            while(!vowels.contains(sArr[start]) && start < end) {
                start++;
            }
            while(!vowels.contains(sArr[end]) && end > start) {
                end--;
            }
            if(start < end) {
                char temp = sArr[start];
                sArr[start] = sArr[end];
                sArr[end] = temp;
                start++;
                end--;
            }
        }
        return new String(sArr);
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("leetcode"));
    }
}
