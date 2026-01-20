package org.northstar.graph;


/**
 * Worst Case time - M union -find operations on N objects
 * Quick Find   O(m*n)
 * Quick Union O(m *N)
 * Weighted QU O(N + M log N)
 * QU + Path Compression O(N + M Log N)
 * Weighted QU + Path Compression O(N + M lg* N)
 *          : 10^9 unions and finds with 10^9 objects
 *          : reduces time from 30yrs to 6 seconds
 *
 *
 *
 */
public class DisjointSets {

    int[] arr;
    int[] height; //weighted union

    public DisjointSets(int size) {
        arr = new int[size];
        for(int i =0; i < arr.length; i++) {
            arr[i] = i;
        }
        height = new int[size];
    }

    public void union(int x, int y) {
        // let x be the head always
        x = getHead(x);
        y = getHead(y);
        // if they have the different head
        if(x != y) {
            if(height[x] < height[y]) {
                arr[x] = arr[y];
                height[y] += arr[x];
            } else {
                arr[y] = arr[x];
                height[x] += arr[y];
            }
        }
    }

    public int getHead(int x) {
        while(arr[x] != x) {
            //path compression with weighted quick union. we are flattening
            // the tree by pointing subtree to the main head.
            arr[x] = arr[arr[x]];
            x = arr[x];
        }
        return x;
    }
    public boolean find(int x, int y) {
       return  getHead(x) == getHead(y);
    }

    public static void main(String[] args) {
        DisjointSets disjointSets = new DisjointSets(10);
        disjointSets.union(0, 1);
        disjointSets.union(0, 2);
        disjointSets.union(0, 3);

        disjointSets.union(4, 8);

        disjointSets.union(5, 7);
        disjointSets.union(5, 6);

        System.out.println("Union of 0 and 3 is : " + disjointSets.find(0, 3));
        System.out.println("Union of 7 and 6 is : " + disjointSets.find(7, 6));
        System.out.println("Union of 4 and 6 is : " + disjointSets.find(4, 6));

        disjointSets.union(7, 8);
        System.out.println("Union of 4 and 6 is : " + disjointSets.find(4, 6));

    }
}
