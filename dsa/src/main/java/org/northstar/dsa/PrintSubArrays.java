package org.northstar.dsa;

public class PrintSubArrays {

    public static void printSubArrays(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                for(int k = i; k <= j; k++) {
                    System.out.print(nums[k] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void printSubArraysLength(int[] nums, int length) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if ((j-i)+1 == length) {
                    for (int k = i; k <= j; k++) {
                        System.out.print(nums[k] + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println("All Sub Arrays");
        printSubArrays(nums);
        System.out.println("Sub arrays of Length 2");
        printSubArraysLength(nums, 2);
    }
}
