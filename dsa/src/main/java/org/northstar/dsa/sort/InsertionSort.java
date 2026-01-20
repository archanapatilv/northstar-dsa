package org.northstar.dsa.sort;

/**
 * Utility class providing an implementation of the insertion sort algorithm.
 * This class cannot be instantiated.
 */
public final class InsertionSort {

    // Private constructor to prevent instantiation
    private InsertionSort() {
        throw new AssertionError("Cannot instantiate utility class");
    }

    /**
     * Sorts the given array in ascending order using the insertion sort algorithm.
     *
     * @param arr the array to be sorted; must not be null
     * @throws IllegalArgumentException if the input array is null
     */
    public static void sort(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Input array must not be null");
        }
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
} 