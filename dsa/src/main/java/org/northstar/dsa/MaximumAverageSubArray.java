package org.northstar.dsa;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumAverageSubArray {
    static public double findMaxAverage(int[] nums, int k) {
        if(null == nums || 0 == nums.length || k > nums.length) {
            return 0;
        }
        if(1 == k & 1 == nums.length) {
            return (double)nums[0];
        }
        double maxSum;
        int sum = 0;
        for(int i = 0; i < k ; i++) {
            sum += nums[i];
        }
        maxSum = sum;
        for(int i = k ; i < nums.length; i++) {
            sum += nums[i] - nums[i-k];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum/k;
    }

    public static void main(String[] args) {
        //System.out.print(findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
        System.out.print(findMaxAverage(new int[]{0,1,1,3,3}, 4));
    }
}
