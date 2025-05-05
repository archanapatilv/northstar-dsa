package org.northstar.dsa.sort;

//Sort a given array using merge sort
public class DivideConquerMergeSort {
    public static void main(String[] args) {
        int a[] = { 12, 11, 13, 5, 6, 7 };

        // Calling of Merge Sort
        DivideConquerMergeSort ob = new DivideConquerMergeSort();
        ob.sort(a, 0, a.length - 1);

        int n = a.length;
        for (int i = 0; i < n; ++i)
            System.out.print(a[i] + " ");
    }

    public void sort(int[] arr, int low, int high) {
        if(low < high) {
            int mid = (low + high)/2;
            sort(arr, low, mid);
            sort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    private void merge(int[] arr, int low, int mid, int high) {
        int leftArrayLength = mid - low + 1;
        int rightArrayLength = high - mid;

        int[] leftArray = new int[leftArrayLength];
        int[] rightArray = new int[rightArrayLength];

        for (int i = 0; i < leftArrayLength; i++)
            leftArray[i] = arr[low + i];
        for (int j = 0; j < rightArrayLength; j++)
            rightArray[j] = arr[mid + 1 + j];

        int i =0, j = 0, k=low;

        while ( i < leftArrayLength && j < rightArrayLength) {
            if(leftArray[i] <= rightArray[j]) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
            }
        }

        for(int m = i; m < leftArrayLength; m++) {
            arr[k++] = leftArray[m];
        }
       for(int m = j; m < rightArrayLength; m++) {
           arr[k++] = rightArray[m];
       }
    }
}
