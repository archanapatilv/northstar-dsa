package org.northstar.dsa;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num: nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (candidate == num) ? 1 : -1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        int nums[] = {2,2,1,1,1,2,2};
        System.out.println("Array : {2,2,1,1,1,2,2} Majority: " + majorityElement(nums) );
        nums = new int[]{0,1,2,2,4,4,1};
        //System.out.println("Array : {0,1,2,2,4,4,1} Majority Even: " + mostFrequentEven(nums));

    }
}
