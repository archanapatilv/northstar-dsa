package org.northstar.dsa.sort;

/**
 * Time complexity: O(n2)
 * best case is difficult to achieve O(nlong) as pivot cant be assumed to the middle of the array
 */
public class QuickSort {
    public static void main(String[] args) {
    int[] arr = new int[] {10, 16, 8, 12, 15, 6, 3, 9, 5};
    QuickSort quickSort = new QuickSort();
    quickSort.quickSort(arr, 0, arr.length-1);
    System.out.println(arr);
    }

    public void quickSort(int[] arr, int low, int high) {
        int partitionKey;
        if (low < high) {
            partitionKey = partition(arr, low, high);
            quickSort(arr, low, partitionKey);
            quickSort(arr, partitionKey+1, high);
        }
    }

    public int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low, j = high;
        while (i < j) {
            while (arr[i] <= pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if(i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, low, j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
