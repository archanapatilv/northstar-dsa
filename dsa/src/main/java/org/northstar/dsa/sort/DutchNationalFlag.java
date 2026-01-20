package org.northstar.dsa.sort;

import java.util.Arrays;

public class DutchNationalFlag {

    enum Color {
        RED, WHITE, BLUE;
    }

    private final Color[] bucket;

    public DutchNationalFlag(Color[] bucket) {
        this.bucket = bucket;
    }

    public void swap(int i , int j) {
        Color temp = bucket[i];
        bucket[i] = bucket[j];
        bucket[j] = temp;
    }

    public Color color(int i) {
        return bucket[i];
    }

    public void sort(Color[] bucket) {
        int low = 0, mid = 0, high = bucket.length-1;
        while(mid <= high) {
            Color c = bucket[mid];
            if(c.equals(Color.WHITE)) {
                mid++;
            } else if (c.equals(Color.RED)) {
                swap(low, mid);
                low++;
                mid++;
            } else {
                swap(mid, high);
                high--;
            }
        }
    }

    public static void main(String[] args) {
        // Example input
        Color[] buckets = new Color[] {
                Color.BLUE, Color.RED, Color.WHITE, Color.BLUE,
                Color.RED, Color.WHITE, Color.RED
        };

        System.out.println("Before sorting:");
        System.out.println(Arrays.toString(buckets));

        DutchNationalFlag dutchNationalFlag = new DutchNationalFlag(buckets);

        dutchNationalFlag.sort(buckets);

        System.out.println("\nAfter sorting:");
        System.out.println(Arrays.toString(buckets));

        //System.out.println("\ncolor() calls: " + colorCalls);
        //System.out.println("swap() calls : " + swapCalls);
    }


}


