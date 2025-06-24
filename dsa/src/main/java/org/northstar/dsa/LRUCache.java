package org.northstar.dsa;

import java.util.*;

public class LRUCache {

    Map<Integer, Integer> cache;
    LinkedList<Integer> orderedList;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<>(capacity);
        orderedList = new LinkedList<>();
    }

    public Integer get(Integer key) {
        if (cache.containsKey(key)) {
            orderedList.remove(key);
            orderedList.addFirst(key);
            return cache.get(key);
        }
        return -1;
    }

    public void put(Integer key, Integer value) {
        if(cache.size() >= capacity) {
            cache.remove(orderedList.removeLast());
        }
        cache.put(key, value);
        orderedList.addFirst(key);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));

    }
}
