package org.northstar.dsa.sort;

import java.util.ArrayList;
import java.util.List;

// O(nlogn)
public class MergeSort {

    public static void main(String[] args) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        arr1.add(2);
        arr1.add(8);
        arr1.add(15);
        arr1.add(18);
        arr2.add(5);
        arr2.add(9);
        arr2.add(12);
        arr2.add(17);
        arr1.add(91);
        MergeSort mergeSort = new MergeSort();
        List<Integer> list = mergeSort.basicMergeSortImproved(arr1, arr2);
        mergeSort.printList(list);

    }

    public void printList(List<Integer> list) {
        for(Integer i: list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    //Basic Merge sort
    public List<Integer> basicMergeSort(List<Integer> arr1, List<Integer> arr2) {
        List<Integer> arr = new ArrayList<>();
        int i=0, j=0;

        for(; i< arr1.size();) {
            for(;j<arr2.size();j++) {
                if(arr1.get(i) < arr2.get(j)) {
                    break;
                } else {
                    arr.add(arr2.get(j));
                }
            }
            arr.add(arr1.get(i));
            i++;
        }
        for(int k=j; k< arr2.size(); k++) {
            arr.add(arr2.get(k));
        }
        return arr;
    }

    //Doesnt work when arr1 length is higher than arr2
    public List<Integer> basicMergeSortImproved(List<Integer> arr1, List<Integer> arr2) {
        List<Integer> arr = new ArrayList<>();
        int i=0, j=0;
        while( i< arr1.size() && j < arr2.size()) {
            if(arr1.get(i) < arr2.get(j)) {
                arr.add(arr1.get(i++));
            } else {
                arr.add(arr2.get(j++));
            }
        }
        for(int k=j; k< arr2.size(); k++) {
            arr.add(arr2.get(k));
        }
        return arr;
    }
}
