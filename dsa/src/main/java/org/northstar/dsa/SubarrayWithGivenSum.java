package org.northstar.dsa;

import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2

Constraints:

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107
 */
public class SubarrayWithGivenSum {

    //Time: O(n^2)
    public static int subarraySum(int[] nums, int sum) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int arraySum = 0;
            for (int j = i; j < nums.length; j++) {
                arraySum = arraySum + nums[j];
                if (arraySum == sum) {
                    count++;
                }
            }
        }
        return count;
    }

    /*
    //Time: O(n)
    //Space: O(n) (for the prefix sum map)
    The prefix sum at index i is the sum of all elements from the start of the array up to index i.
    If prefixSum[j] - prefixSum[i] = target, then the subarray from i+1 to j sums to target.
    */
    public static int countSubarraysWithSum(int[] nums, int sum) {
        int count = 0;
        //Key: a prefix sum value
        //Value: the number of times this prefix sum has occurred so far
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0,1); // Handle subarrays starting at index 0
        int currentSum = 0;
        for(int num: nums) {
            currentSum+= num;
            //does this exist in prefixSumCount?
            //If yes, then there are as many subarrays ending here as the count of that prefix sum.
            count += prefixSumCount.getOrDefault(currentSum - sum, 0);
            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 2, 3, -3};
        int sum = 3;
        System.out.println("The number of subarrays in {3, 1, 2, 3, -3} " +
                "of sum 3 are " + subarraySum(nums, sum));

        System.out.println("The number of subarrays in {3, 1, 2, 3, -3} " +
                "of sum 3 are " + countSubarraysWithSum(nums, sum));
    }
}
