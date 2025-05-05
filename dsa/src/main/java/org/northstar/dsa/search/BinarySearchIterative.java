package org.northstar.dsa.search;

public class BinarySearchIterative {
    public static void main(String[] args) {
        BinarySearchIterative binarySearchIterative = new BinarySearchIterative();

        int[] arr = new int[] {9, 10, 15, 17, 21, 37, 40, 42, 77, 89, 99, 101};
        int key = 42;
        int index = binarySearchIterative.search(arr, key);
        System.out.println( index == -1? "Key "+ key + " Not Found": "Key " + key + " Found at index " + index);
        key = 412;
        index = binarySearchIterative.search(arr, key);
        System.out.println( index == -1? "Key "+ key + " Not Found": "Key " + key + " Found at index " + index);
        key = 9;
        index = binarySearchIterative.search(arr, key);
        System.out.println( index == -1? "Key "+ key + " Not Found": "Key " + key + " Found at index " + index);
        key = 101;
        index = binarySearchIterative.search(arr, key);
        System.out.println( index == -1? "Key "+ key + " Not Found": "Key " + key + " Found at index " + index);

    }
    int search(int[] arr, int key) {
        int low = 0, high = arr.length - 1, mid = 0;
        while (low <= high) {
            mid = (low+high)/2;
            if(arr[mid] == key) {
                return mid;
            }
            if(key < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
