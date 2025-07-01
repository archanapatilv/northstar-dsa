package org.northstar.dsa;

import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//Minimum Window Substring
public class SmallestWindowContainingAllChars {
    public static String minimumWindowSubstring(String s, String t) {
        if(null == s || null == t || t.isEmpty() || s.isEmpty() || t.length() > s.length()) {
            return "";
        }
        // Char, Count of occurrence
        Map<Character, Integer> tChars = new HashMap<>();
        int requiredLength = t.length();
        for (int i = 0; i < requiredLength; i++) {
            int count = tChars.getOrDefault(t.charAt(i), 0);
            tChars.put(t.charAt(i), count+1);
        }
        // character, count of occurrence in String s
        Map<Character, Integer> tracker = new HashMap<>();
        // track the indexes to find next index once we remove
        // the first found character as we found a match of string t
        List<Integer> indexList = new LinkedList<>();
        int startIndex = -1;
        int currentFoundLength = 0;
        int[] index = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        int currentLength = 0, prevLength = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if(tChars.containsKey(c)) {
                indexList.add(i);
                startIndex = startIndex == -1 ? i : startIndex;
                int value = tracker.getOrDefault(c, 0);
                tracker.put(c, value + 1);
                if(tracker.get(c) <= tChars.get(c)) {
                    currentFoundLength++;
                }
                while (requiredLength == currentFoundLength) {
                    currentLength = i - startIndex + 1;
                    if (currentLength < prevLength) {
                        index = new int[]{startIndex , i};
                    }
                    int v = tracker.getOrDefault(s.charAt(startIndex), -1);
                    if (v > 1) {
                        tracker.put(s.charAt(startIndex), v -1);
                        if(tChars.get(s.charAt(startIndex)) > tracker.get(s.charAt(startIndex))) {
                            currentFoundLength--;
                            indexList.remove(0);
                            startIndex = !indexList.isEmpty() ? indexList.get(0): -1;
                        } else {
                            indexList.remove(0);
                            startIndex = !indexList.isEmpty() ? indexList.get(0): -1;
                        }
                    } else {
                        tracker.remove(s.charAt(startIndex));
                        currentFoundLength--;
                        indexList.remove(0);
                        startIndex = !indexList.isEmpty() ? indexList.get(0): -1;
                    }
                    prevLength = Math.min(currentLength, prevLength);
                }
            }
        }
        if (index[0] == Integer.MAX_VALUE) {
            return "";
        } else {
            return s.substring(index[0], index[1]+1);
        }
    }

    public static void main(String[] args) {
        System.out.println(minimumWindowSubstring("ADOBECODEBANC", "BAC"));
        System.out.println(minimumWindowSubstring("bba", "ab"));
        System.out.println(minimumWindowSubstring("abcabdebac", "cda"));
    }
}
