package org.northstar.dsa;

/*
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
Return k.
Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.



Example 1:

Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).


Constraints:

1 <= nums.length <= 3 * 104
-100 <= nums[i] <= 100
nums is sorted in non-decreasing order.
*/
public class RemoveDuplicatesInSortedArray {

    public static int removeDuplicates(int[] nums) {
        if(null == nums || nums.length == 0) {
            return 0;
        }
        int currentIndex = 1;
        int availableIndex = -1;
        for (;currentIndex < nums.length; currentIndex++) {
            if((nums[currentIndex] == nums[currentIndex-1])) {
                if(availableIndex == -1)
                    availableIndex = currentIndex;
            } else {
                if (availableIndex != -1) {
                    nums[availableIndex] = nums[currentIndex];
                    availableIndex++;
                }
            }
        }
        return availableIndex == -1 ? nums.length: availableIndex;
    }

    public static int removeDuplicatesOptimised(int[] nums) {
        if(null == nums || nums.length == 0) {
            return 0;
        }
        int currentIndex = 1;
        int availableIndex = 1;
        while(currentIndex < nums.length) {
            if(nums[currentIndex] != nums[currentIndex-1]) {
                nums[availableIndex] = nums[currentIndex];
                currentIndex++;
                availableIndex++;
            } else {
                currentIndex++;
            }
        }
        return availableIndex;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        System.out.println("The unique element count for {1, 1, 2} is : " + removeDuplicatesOptimised(nums));

        nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println("The unique element count for {0,0,1,1,1,2,2,3,3,4} is : " + removeDuplicatesOptimised(nums));

        nums = new int[]{0,1,2,3,4,4,5,5,6};
        System.out.println("The unique element count for {0,1,2,3,4,4,5,5,6} is : " + removeDuplicatesOptimised(nums));

        nums = new int[]{0,1,2,3,4,5,6};
        System.out.println("The unique element count for {0,1,2,3,4,5,6} is : " + removeDuplicatesOptimised(nums));
    }

}
