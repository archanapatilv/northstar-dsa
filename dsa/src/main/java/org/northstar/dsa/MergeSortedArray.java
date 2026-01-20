package org.northstar.dsa;

public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        for(; i < m && j < n; i++) {
            if(nums1[i] > nums2[j]) {
                int temp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = temp;
            } else if (nums1[i] == nums2[j]) {
                if(nums1[i + 1] != 0) {
                    int temp = nums1[i + 1];
                    nums1[i + 1] = nums2[j];
                    nums2[j] = temp;
                }
            } else {
                continue;
            }
        }
        while(j < n) {
            nums1[i++] = nums2[j++];
        }

    }

    public static void main(String[] args) {
        MergeSortedArray.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }
}
