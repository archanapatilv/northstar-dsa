package org.northstar.autocomplete;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Autocomplete {
    Trie trie = new Trie();

    public Optional<List<String>> getSuggestions(String search) {
        return trie.getSuggestions(search);
    }
    public void buildSuggestions(String key) {
        trie.insert(key);
    }
}
