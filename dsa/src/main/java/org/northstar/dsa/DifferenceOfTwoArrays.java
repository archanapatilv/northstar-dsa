package org.northstar.dsa;

import java.util.*;
import java.util.stream.Collectors;

public class DifferenceOfTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>();
        if(null == nums1 && null == nums2) {
            return result;
        }
        if(null == nums1) {
            return result;
        }
        if(null == nums2 ) {
            return result;
        }
        if(0 == nums1.length) {
            result.add(Arrays.stream(nums2).boxed().collect(Collectors.toList()));
            return result;
        }
        if(0 == nums2.length) {
            result.add(Arrays.stream(nums1).boxed().collect(Collectors.toList()));
            return result;
        }

        Set<Integer> num2Set = new HashSet<>();
        for(int num: nums2) {
            num2Set.add(num);
        }
        Set<Integer> num1Set = new HashSet<>();
        for(int num: nums1) {
            num1Set.add(num);
        }
        result.add(new ArrayList<>());
        Set<Integer> commons = new HashSet<>();
        for(int num: num1Set) {
            if(num2Set.contains(num) || (!commons.isEmpty() && commons.contains(num))) {
                commons.add(num);
                num2Set.remove(num);
            } else {
                result.get(0).add(num);
            }
        }
        result.add(new ArrayList<>(num2Set));
        return result;
    }
}
