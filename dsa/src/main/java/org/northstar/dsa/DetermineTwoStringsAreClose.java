package org.northstar.dsa;

import java.util.*;

public class DetermineTwoStringsAreClose {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) {
            return false;
        }
        Map<Character, Integer> word1Map = new HashMap<>();
        Map<Character, Integer> word2Map = new HashMap<>();
        for(char c : word1.toCharArray()) {
            word1Map.put(c, word1Map.getOrDefault(c, 0) + 1);
        }
        for(char c : word2.toCharArray()) {
            word2Map.put(c, word2Map.getOrDefault(c, 0) + 1);
        }
        if(!word1Map.keySet().equals(word2Map.keySet())) {
            return false;
        }
        List<Integer> word1List = new ArrayList<>(word1Map.values());
        List<Integer> word2List = new ArrayList<>(word2Map.values());
        Collections.sort(word1List);
        Collections.sort(word2List);
        return word1List.equals(word2List);

    }
}
