package org.northstar.dsa;

public class MaxConsecutiveOnes {

    public static int longestOnes(int[] nums, int k) {
        if(null == nums || 0 == nums.length || k > nums.length) {
            return 0;
        }
        if(1 == k & 1 == nums.length) {
            return 0 == nums[0] ? 1 : 0;
        }
        int left = 0, count = 0, max=0;
        for(int right = 0; right < nums.length; right++) {
            if(nums[right] == 0) {
                count++;
            }
            while(count > k) {
                if(nums[left] == 0) {
                    count--;
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        //int[] nums = {1, 1, 1, 0, 1};
        int[] nums = {1, 0, 1, 0, 1, 0, 1, 1};

        int max = longestOnes(nums, 2);
        System.out.println(max);
    }
}
