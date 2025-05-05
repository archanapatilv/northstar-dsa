package org.northstar.dsa.search;

import java.util.Arrays;

/**
 * Given an array heapify it
 * 1. Use the delete approach of swapping from downward to upward
 * <p>
 * Time complexity : O(n)
 * As heap creation in Max Heap class is nlogn , this method is better
 */
public class Heapify {
    public static void main(String[] args) {
        int[] arr = {10, 20, 15, 12, 40, 25, 18};

        Heapify heapify = new Heapify();
        heapify.print(arr);
        heapify.heapify(arr, arr.length - 1);
        heapify.print(arr);
    }

    public int[] heapify(int[] arr, int index) {
        for (int i = index; i >= 0; i--) {
            arr = internalHeapify(arr, i);
        }
        return arr;
    }

    private int[] internalHeapify(int[] arr, int index) {
        if (!isLeaf(index, arr)) {
            int leftIndex = getLeftChildIndex(index);
            int rightIndex = getRightChildIndex(index);
            if (leftIndex < arr.length && arr[leftIndex] > arr[index]) {
                if (rightIndex < arr.length && arr[leftIndex] > arr[rightIndex]) {
                    swap(arr, index, leftIndex);
                    internalHeapify(arr, leftIndex);
                } else if (rightIndex < arr.length) {
                    swap(arr, index, rightIndex);
                    internalHeapify(arr, rightIndex);
                }
            } else if (rightIndex < arr.length && arr[rightIndex] > arr[index]) {
                swap(arr, index, rightIndex);
                internalHeapify(arr, rightIndex);
            }
        }
        return arr;
    }


    private boolean isLeaf(int index, int[] a) {
        if (getLeftChildIndex(index) > a.length || getRightChildIndex(index) > a.length) {
            return true;
        }
        return false;
    }

    private void swap(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }

    private int getLeftChildIndex(int givenIndex) {
        return (givenIndex * 2) + 1;
    }

    private int getRightChildIndex(int givenIndex) {
        return (givenIndex * 2) + 2;
    }

    private int getParentIndex(int givenIndex) {
        return (givenIndex - 1) / 2;
    }

    public void print(int[] arr) {
        Arrays.stream(arr).forEach(a -> System.out.print(a + " , "));
        System.out.println();
    }
}
