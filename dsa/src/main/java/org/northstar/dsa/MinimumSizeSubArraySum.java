package org.northstar.dsa;

public class MinimumSizeSubArraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int total  = 0;
        int result = Integer.MAX_VALUE;
        while(right < nums.length) {
            if(nums[right] >= target) {
                return 1;
            }
            total += nums[right];
            while(total >= target) {
                result = Math.min(result, right-left+1);
                total -= nums[left++];
            }
            right++;
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static void main(String[] args) {
        MinimumSizeSubArraySum ms = new MinimumSizeSubArraySum();
       int res = ms.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
       System.out.println(res);
    }
}
