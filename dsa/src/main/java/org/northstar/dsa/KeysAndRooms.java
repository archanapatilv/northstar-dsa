package org.northstar.dsa;

import java.util.*;

public class KeysAndRooms {

    static public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        int[] present = new int[n];
        List<Integer> keys = rooms.get(0);
        present[0] = 1;
        int foundCount = 1; // room 0 is always unlocked
        Queue<Integer> queue = new LinkedList<>();
        for(Integer key : keys) {
            queue.add(key);
        }
        while(!queue.isEmpty()) {
            int key = queue.poll();;
            if(present[key] == 0) {
                present[key] = 1;
                foundCount++;
                queue.addAll(rooms.get(key));
            }
            if(foundCount == n) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Integer[] a = {1, 3};
        Integer[] b = {3, 0, 1};
        Integer[] c = {2};
        Integer[] d = {0};
        List<Integer> l1 = new ArrayList<>(Arrays.asList(a));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(b));
        List<Integer> l3 = new ArrayList<>(Arrays.asList(c));
        List<Integer> l4 = new ArrayList<>(Arrays.asList(d));
        List<List<Integer>> m = new ArrayList<>();
        m.add(l1);m.add(l2);m.add(l3);m.add(l4);
        System.out.println(canVisitAllRooms(m));
    }

    public boolean _canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        int[] present = new int[n];
        // present[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < rooms.get(i).size(); j++) {
                if (i == 0) {
                    present[rooms.get(i).get(j)] = 1;
                } else {
                    if (present[i] == 0) {
                        return false;
                    } else {
                        present[rooms.get(i).get(j)] = 1;
                    }
                }
            }
        }

        return true;
    }
}
