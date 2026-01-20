package org.northstar.dsa;

/**
 * Given an array of heights, finds the maximum area of water a container can store.
 * Uses the two-pointer approach for optimal O(n) time complexity.
 */
public final class ContainerWithMostWater {

    // Private constructor to prevent instantiation of utility class
    private ContainerWithMostWater() {
        throw new AssertionError("Cannot instantiate utility class");
    }

    /**
     * Returns the maximum area of water a container can store.
     *
     * The idea is to use two pointers, one at the beginning and one at the end of the array.
     * At each step, calculate the area formed by the lines at the two pointers and the x-axis.
     * Move the pointer pointing to the shorter line inward, since the area is limited by the shorter line.
     * This ensures all possible container widths are considered in O(n) time.
     *
     * @param height array of non-negative integers representing heights
     * @return maximum area
     * @throws IllegalArgumentException if height is null
     */
    public static int maxArea(int[] height) {
        if (height == null) {
            throw new IllegalArgumentException("Input array must not be null");
        }
        int maxArea = 0;
        int left = 0; // Left pointer starts at the beginning
        int right = height.length - 1; // Right pointer starts at the end

        // Loop until the two pointers meet
        while (left < right) {
            // Height is determined by the shorter of the two lines
            int h = Math.min(height[left], height[right]);
            // Width is the distance between the two pointers
            int w = right - left;
            // Calculate the area and update maxArea if it's larger
            int area = h * w;
            if (area > maxArea) {
                maxArea = area;
            }
            // Move the pointer pointing to the shorter line inward
            // This is because moving the longer line inward cannot increase the area
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
} 