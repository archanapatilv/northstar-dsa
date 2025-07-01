package org.northstar.dsa;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
Given an array arr[] of integers and an integer k,
your task is to find the maximum value for each contiguous subarray of size k.
The output should be an array of maximum values corresponding to each
contiguous subarray.

Examples:

Input: arr[] = [1, 2, 3, 1, 4, 5, 2, 3, 6], k = 3
Output: [3, 3, 4, 5, 5, 5, 6]
 */
public class KSizedSubarrayMaximum {
    static int min = Integer.MAX_VALUE;
    public static int[] findKSizedSubArrayMaximum(int[] nums, int k) {
        if (k <= 0 || null == nums) {
            return new int[]{};
        }
        /*if(k == 1) {
            return nums;
        }*/
        Deque<Integer> deck = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        int i = 0, j = 0;
        for(; i < k; i++) {
            while (!deck.isEmpty() && nums[i] >= nums[deck.peekLast()]) {
                deck.pollLast();
            }
            deck.offerLast(i);
        }
        min = Math.min(min, nums[deck.peekFirst()]);
        result[j++] = nums[deck.peekFirst()];
        for(; i < nums.length; i++) {
            //we need to remove if the value in deque is not valid as per k
            // lets say k = 2, you need to remove the earlier element
            if(deck.peekFirst() == i - k) {
                deck.pollFirst();
            }
            while (!deck.isEmpty() && nums[i] >= nums[deck.peekLast()]) {
                deck.pollLast();
            }
            deck.offerLast(i);
            min = Math.min(min, nums[deck.peekFirst()]);
            result[j++] = nums[deck.peekFirst()];
        }
        return result;
    }

    public static void main(String[] args) {
        //int[] arr = new int[]{1, 2, 3, 1, 4, 5, 2, 3, 6 };
        //int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] arr = {4, 3, 11};
        int k = 3;
        System.out.println(Arrays.toString(findKSizedSubArrayMaximum(arr, k)));
    }
}
