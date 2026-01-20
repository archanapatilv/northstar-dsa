package org.northstar.dsa;

public class MoveZeros {
    static public void moveZeroes(int[] nums) {
        if(null == nums || nums.length <= 1) {
            return;
        }
        int len = nums.length;
        int availableIndex = -1;
        int index = 0;
        while(index < len) {
            if(nums[index] == 0) {
                availableIndex = (availableIndex == -1) ? index : availableIndex;
            } else {
                if(-1 != availableIndex) {
                    nums[availableIndex++] = nums[index];
                    nums[index] = 0;
                }
            }
            index++;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);
        for(int n: nums) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
