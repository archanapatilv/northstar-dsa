package org.northstar.dsa.search;

public class BinarySearch {

    int[] a = {1,3, 4, 9, 10, 14, 16, 29, 31, 42};

    /*
    Calling itself by half
    1. IF size = 1, then 1 check only
    2. T(n) = T(n/2) + 1
    3. Time complexity: logn
     */
    public int search(int low, int high, int key) {
        if( low == high) {
            if (a[low] == key) {
                return low;
            } else {
                return -1;
            }
        }
        int mid = (low + high)/2;
        if(key == a[mid]) {
            return mid;
        } else if(key < a[mid]) {
            return search(low, mid-1, key);
        } else {
            return search(mid+1, high, key);
        }
    }

    public void searchTest( int key) {
        System.out.println("Element "+ key+ " found at index : " + search(0, 9, 31));
    }

    public static void main(String[] args) {
        BinarySearch search = new BinarySearch();
        search.searchTest(31);
        search.searchTest(91);
    }
}
