package org.northstar.dsa;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Case Sensitive????

Time complexity : n is the number of string in the array and m is the average length of strings,
its O(m * n)

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.


Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters if it is non-empty.
*/
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if(null == strs || strs.length == 0) {
            return "";
        }
        if(null == strs[0] || strs[0].isEmpty()) {
            return "";
        }
        int patternMatchIndex = 0;
        StringBuilder commonPrefix = new StringBuilder();
        while (patternMatchIndex < strs[0].length()) {
            for (int i = 1; i < strs.length; i++) {
                if (null == strs[i] || strs[i].isEmpty()) {
                    return "";
                }
                //Case sensitive check
                if (patternMatchIndex >= strs[i].length() ||
                        strs[i].charAt(patternMatchIndex) != strs[0].charAt(patternMatchIndex)) {
                    return commonPrefix.toString();
                }
            }
            commonPrefix.append(strs[0].charAt(patternMatchIndex));
            patternMatchIndex++;
        }
        return commonPrefix.toString();
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println("The longest common prefix of {flower, flow, flight} is : " + longestCommonPrefix(strs));
        strs = new String[]{"dog","racecar","car"};
        System.out.println("The longest common prefix of {dog, racecar, car} is : " + longestCommonPrefix(strs));
        strs = new String[]{null,"racecar","car"};
        System.out.println("The longest common prefix of {null, racecar, car} is : " + longestCommonPrefix(strs));
        strs = new String[]{"","racecar","car"};
        System.out.println("The longest common prefix of {\"\", racecar, car} is : " + longestCommonPrefix(strs));
        strs = new String[]{"dog",null,"car"};
        System.out.println("The longest common prefix of {dog, null, car} is : " + longestCommonPrefix(strs));
        strs = new String[]{"dog","racecar",""};
        System.out.println("The longest common prefix of {dog, racecar, \"\"} is : " + longestCommonPrefix(strs));
        strs = new String[]{"dog","dog","dog"};
        System.out.println("The longest common prefix of {dog, dog, dog} is : " + longestCommonPrefix(strs));
    }
}
