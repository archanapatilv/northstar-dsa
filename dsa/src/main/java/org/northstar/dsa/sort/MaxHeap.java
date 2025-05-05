package org.northstar.dsa.sort;


import java.util.Arrays;

public class MaxHeap {
/*
               50
          30         20
    15       10   8      16

    Time complexity: O(1) and O(nlogn) swapping depends on height for both insert and delete

    Insert
    1. Add new element as leaf
    2. Compare with its ancestors
    3. The direction of comparison is upwards

    Delete:
    1. Only root element is deleted. Then only its a heap
    2. The above example only 50 can be deleted
    3. Preserve complete binary tree
    4. Last element in the complete binary tree will be made root
    5. Adjust the elements
    6. The direction of comparison is downwards
*/

    int[] a = new int[8]; //{50, 30, 20, 15, 10, 8, 16, -1};
    int heapSize = 8;
    int currentHeapSize = -1;

    public void insert(int value) {
        if(currentHeapSize+1 >= a.length) {
            return;
        }
        a[++currentHeapSize] = value;
        adjustParent(currentHeapSize);
    }

    private int getLeftChildIndex(int givenIndex) {
        return (givenIndex * 2) + 1;
    }

    private int getRightChildIndex(int givenIndex) {
        return (givenIndex * 2) + 2;
    }

    private int getParentIndex(int givenIndex) {
        return (givenIndex - 1)/2;
    }

    public int delete() {
        if(currentHeapSize < 0) {
                return -1;
        }
        // Get the root value (basically remove from array)
        int value = a[0];
        // Put the last element in the root position
        a[0] = a[currentHeapSize];
        //optional, can store in the empty space
        a[currentHeapSize] = value;
        currentHeapSize--;
        //Adjust
        adjustChildren(0);
        return value;
    }

    private void adjustChildren(int index) {
        if(index <= currentHeapSize) {
            int leftIndex = getLeftChildIndex(index);
            int rightIndex = getRightChildIndex(index);
            if(leftIndex <= currentHeapSize && rightIndex <= currentHeapSize ) {
                if(a[index] < a[leftIndex] || a[index] < a[rightIndex]) {
                    if (a[leftIndex] >= a[rightIndex]) {
                        swap(index, leftIndex);
                        adjustChildren(leftIndex);
                    } else {
                        swap(index, rightIndex);
                        adjustChildren(rightIndex);
                    }
                }
            } else if(leftIndex <= currentHeapSize &&  a[leftIndex] > a[index]) {
                swap(index, leftIndex);
                adjustChildren(leftIndex);
            }
        }
    }

    private void adjustParent(int index) {
        if(index > 0) {
            int parentIndex = getParentIndex(index);
            if (a[index] > a[parentIndex]) {
                swap(index, parentIndex);
                adjustParent(parentIndex);
            }
        }
    }

    private void swap(int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }

    public void print() {
        Arrays.stream(a).forEach(a -> System.out.print(a + " , "));
        System.out.println();
    }

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap();
        heap.insert(50);
        heap.insert(30);
        heap.insert(20);
        heap.insert(15);
        heap.insert(10);
        heap.insert(8);
        heap.insert(16);
        heap.insert(60);
        heap.print();

        heap.delete();
        //heap.print();

        heap.delete();
        //heap.print();
        heap.delete();
        heap.delete();
        heap.delete();
        heap.delete();
        heap.delete();
        heap.delete();
        heap.print();
    }
}
