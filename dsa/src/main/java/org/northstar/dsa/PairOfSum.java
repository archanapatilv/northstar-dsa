package org.northstar.dsa;

import java.util.HashSet;
import java.util.Set;

public class PairOfSum {

    public static boolean twoSum(int[] nums, int target) {
        if(null == nums || nums.length <= 1) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            int secondValue = target - num;
            if (set.contains(secondValue)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args){

        int[] arr = { 0, -1, 2, -3, 1 };
        int target = -2;

        // Call the twoSum function and print the result
        if (twoSum(arr, target))
            System.out.println("true");
        else
            System.out.println("false");
    }
}
