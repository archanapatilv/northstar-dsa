package org.northstar.dsa;

import java.util.*;

class RandomizedSet {

    private List<Integer> list;
    private Map<Integer, Integer> map;
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(list.size(), val);
        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int index = map.get(val);
        if(index == list.size() - 1) {
            list.remove(index);
            map.remove(val);
        } else {
            int lastVal = list.get(list.size()-1);
            int lastIndex = map.get(lastVal);
            map.remove(lastVal);
            map.put(lastVal, index);
            list.remove(lastIndex);
            list.add(index, lastVal);
        }
        return true;
    }

    public int getRandom() {
        if(list.size() == 1) {
            return list.get(0);
        }
        int i = (int) (Math.random() * list.size());
        return list.get(i);
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        /*randomizedSet.remove(0);
        randomizedSet.remove(0);
        randomizedSet.insert(0);
        int n = randomizedSet.getRandom();
        randomizedSet.remove(0);
        randomizedSet.remove(0);*/

        /*Random random = new Random();
        for(int i = 0; i < 20; i++)
            System.out.println(random.nextInt(2));*/

        randomizedSet.insert(1);
        randomizedSet.remove(2);
        randomizedSet.insert(2);
        int n = randomizedSet.getRandom();
        randomizedSet.remove(1);
        randomizedSet.insert(2);
         n = randomizedSet.getRandom();

    }
}
