package org.northstar.dsa;

public class FindingPivotIndex {
    static public int pivotIndex(int[] nums) {
        if(null == nums || 0 == nums.length) {
            return -1;
        }
        int len = nums.length;
        int sum = 0;
        for(int num: nums) {
            sum += num;
        }
        int leftSum = 0;
        for(int i = 0; i < len; i++) {
            if(leftSum == sum - leftSum - nums[i])
                return i;
            leftSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Pivot index iof {1,7,3,6,5,6} is : " + pivotIndex(new int[]{1,7,3,6,5,6}));
    }
}
