package org.northstar.dsa;

public class ProductOfArrayExceptSelf {
    static public int[] productExceptSelf(int[] nums) {
        if(null == nums || nums.length <= 1) {
            return nums;
        }
        int[] res = new int[nums.length];
        res[0] = 1; // Prefix for 1st value;
        for(int i = 1; i < nums.length; i++) {
            res[i] = nums[i-1] * res[i-1];
        }
        int postFix = 1;
        for(int i = nums.length - 1; i >= 0 ; i-- ) {
            res[i] = res[i] * postFix;
            postFix *= nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(productExceptSelf(new int[]{1, 2, 3, 4}));
    }
}
