package org.northstar.autocomplete;

import java.util.*;

public class Trie {
    Map<Character, Trie> trieCache = new HashMap<>();
    //Map<String, Integer> metadata = new HashMap<>();

    public Optional<List<String>> getSuggestions(final String key) {
        List<String> result = new ArrayList<>();
        if(key.isBlank()) {
            return Optional.empty();
        }
        String tempKey = key;
        char c; 
        Map<Character, Trie> temp = trieCache;
        while(tempKey.length() > 1 && null != temp) {
            c = tempKey.charAt(0);
            temp = temp.get(c).trieCache;
            tempKey = tempKey.substring(1);
        }

        temp.get(tempKey.charAt(0)).trieCache.keySet().forEach(s -> result.add(key+s));
        return Optional.of(result);
    }

    public void insert(String key) {
        if(key.isBlank()) {
            return;
        }
        Map<Character, Trie> temp = trieCache;
        while (!key.isBlank()) {
            if(null == temp.get(key.charAt(0))) {
                Trie c = new Trie();
                temp.put(key.charAt(0), c);
            }
            temp = temp.get(key.charAt(0)).trieCache;
            key = key.substring(1);
        }
    }
}
