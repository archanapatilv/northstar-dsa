package org.northstar.dsa;

public class MaximumSubArraySum {

    //Kadene's algorithm
    public static int maxSubArray(int[] nums) {
        int result = nums[0];
        int maxSubArraySum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxSubArraySum = Math.max(maxSubArraySum + nums[i], nums[i]);
            result = Math.max(result, maxSubArraySum);
        }
        return  result;
    }

    public static void main(String[] args) {
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
