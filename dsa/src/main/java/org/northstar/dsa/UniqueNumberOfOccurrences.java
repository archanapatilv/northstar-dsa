package org.northstar.dsa;

import java.util.HashMap;
import java.util.Map;

public class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        if(null == arr ) {
            return false;
        }
        int len = arr.length;
        if(0 == len || 1 == len) {
            return false;
        }
        Map<Integer, Integer> occCount = new HashMap<>();
        for(int num: arr) {
            occCount.put(num, occCount.getOrDefault(num, 0) + 1);
        }
        return occCount.values().size() == occCount.values().stream().distinct().count();

    }
}
