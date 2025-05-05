package org.northstar.autocomplete;

import org.junit.Assert;
import org.junit.Test;
import org.northstar.linkedlist.DoublyLinkedList;

import java.util.List;
import java.util.Optional;

public class AutocompleteTest {
    @Test
    public void testInsert(){
       String key = "abc";
       Autocomplete autocomplete = new Autocomplete();
       autocomplete.buildSuggestions(key);
       Optional<List<String>> a = autocomplete.getSuggestions("a");
       Optional<List<String>> ab = autocomplete.getSuggestions("ab");
       Optional<List<String>> abc = autocomplete.getSuggestions("abc");
       System.out.println("Finished");
    }

}
