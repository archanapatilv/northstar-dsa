package org.northstar.dsa;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//K items and t target
public class AllTripletswithZeroSum {

    public static List<List<Integer>> getTriplets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++) {
            for (int j = i+1; j < nums.length -1; j++) {
                for(int k = j+1; k < nums.length; k++) {
                    if(nums[i] + nums[j] + nums[k] == 0) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return result;
    }

    public static List<List<Integer>>  getSubarrayWithSum(int[] nums, int sum) {
        Set<Integer> set = new TreeSet<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            set.clear();
            for(int j = i+1 ; j < nums.length; j++) {
                int thirdElement = -(nums[i] + nums[j]);
                if (set.contains(thirdElement)) { //ie third element to make that "sum"
                    result.add(Stream.of(nums[i], nums[j], thirdElement).sorted().collect(Collectors.toList()));
                }
                set.add(nums[j]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};//{0, -1, 2, -3, 1};
        List<List<Integer>> triplets = getTriplets(nums);
        System.out.println(triplets);
        nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println("Triplest sum zero : " + getSubarrayWithSum(nums, 0));
    }

}
