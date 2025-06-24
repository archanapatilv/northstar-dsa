package org.northstar.dsa;

import java.util.*;

public class TwoSumTarget {
   public static  List<List<Integer>> twoSumArray(int[] nums, int target) {
       if(null == nums || nums.length <= 1) {
           return new ArrayList<>();
       }
       List<List<Integer>> result = new ArrayList<>();
       Map<Integer, Integer> prefixMap = new HashMap<>();
       for(int index = 0; index < nums.length; index++) {
           if (prefixMap.containsKey(target - nums[index])) {
               result.add(Arrays.asList(prefixMap.get(target - nums[index]), index));
           }
           prefixMap.put(nums[index], index);
       }
       return result;
   }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 1, 2, 4, -2};
        int target = 2;
        List<List<Integer>> lists = twoSumArray(nums, target);
        System.out.println(lists);
    }
}
