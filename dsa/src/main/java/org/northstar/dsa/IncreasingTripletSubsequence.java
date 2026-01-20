package org.northstar.dsa;

public class IncreasingTripletSubsequence   {
    static public boolean increasingTriplet(int[] nums) {
        if(null == nums || nums.length < 3) {
            return false;
        }
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for(int num: nums) {
            if(first >= num) {
                first = num;
            } else if (second >= num) {
                second = num;
            } else {
                return true;
            }
        }
        return false;
    }
    static public boolean increasingKSubsequence(int[] nums, int k) {
        if(null == nums || nums.length < 3) {
            return false;
        }
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for(int num: nums) {
            if(first >= num) {
                first = num;
            } else if (second >= num) {
                second = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
