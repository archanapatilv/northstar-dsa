package org.northstar.dsa;

public class MaximumSumCircularSubArray {

    public static int maxSubarraySumCircular(int[] nums) {
        if(null == nums || nums.length == 0) {
            return 0;
        }
        int maxSum = nums[0];
        int minSum = nums[0];
        int currentMaxSum = 0;
        int currentMinSum = 0;
        int totalSum = 0;

        for(int i = 0; i < nums.length; i++) {

            totalSum += nums[i];
            // Normal Kadane's algo
            currentMaxSum = Math.max(currentMaxSum, 0) + nums[i];
            maxSum = Math.max(maxSum, currentMaxSum);
            //same but for min
            currentMinSum = Math.min(currentMinSum, 0) + nums[i];
            minSum = Math.min(minSum, currentMinSum);

        }
        //This means its at the center
        if(totalSum == minSum) {
            return maxSum;
        }
        // edge cases
        return Math.max(maxSum, totalSum-minSum);

    }

    public static void main(String[] args) {
        System.out.println(maxSubarraySumCircular(new int[]{1, -2, 3, -2}));
        System.out.println(maxSubarraySumCircular(new int[]{5, -3, -2, 6, -1, 4}));
        System.out.println(maxSubarraySumCircular(new int[]{5,-3,5}));
        System.out.println(maxSubarraySumCircular(new int[]{-3,-2,-3}));

    }
}
