package org.northstar.dsa;

public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        if(null == nums || 0 == nums.length) {
            return 0;
        }
        int index = 0;
        int endIndex = nums.length -1;
        while(index <= endIndex) {
            if(nums[index] == val) {
                while(nums[endIndex] == val && endIndex > index) {
                    endIndex--;
                }
                int temp = nums[index];
                nums[index] = nums[endIndex];
                nums[endIndex] = temp;
                endIndex--;
            }
            index++;
        }
        return endIndex+1;
    }

    public static void main(String[] args) {
        System.out.print("Size after removing element : "
                + removeElement(new int[]{3, 2, 2, 3}, 3));
    }
}
