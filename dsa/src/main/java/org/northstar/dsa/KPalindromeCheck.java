package org.northstar.dsa;


import java.util.HashMap;
import java.util.Map;

/*
1. Characters with odd frequencies must be at the center of the palindrome
2. The number of odd frequencies determine
  whether a palindrome of k items can be constructed with the given string
3. The number of odd frequencies < k, then its possible
 */
public class KPalindromeCheck {

    public static boolean isKPlaindromePossible(String string, int k) {
        if(null == string) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < string.length(); i++) {
            map.put(string.charAt(i),
                    map.getOrDefault(string.charAt(i), 0) + 1);
        }
        int countOfOddFrequencies = 0;
        for (Integer value : map.values()) {
            if(countOfOddFrequencies > k) {
                return false;
            } else if ((value % 2) != 0) {
                countOfOddFrequencies++;
            }
        }
       return true;
    }

    public static void main(String[] args) {
        String s = "annabelle";
        int k = 2;
        System.out.println(k + " palindromes can be " +
                "formed with string: " + s + " : " + isKPlaindromePossible(s, k));

        s = "leetcode";
        k = 3;
        System.out.println(k + " palindromes can be " +
                "formed with string: " + s + " : " + isKPlaindromePossible(s, k));

        s = "true";
        k = 4;
        System.out.println(k + " palindromes can be " +
                "formed with string: " + s + " : " + isKPlaindromePossible(s, k));
    }
}
