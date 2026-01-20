package org.northstar.dsa.sort;

import java.util.Arrays;
import java.util.Comparator;

public class SortTest {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{10,16},{2,8},{1,6},{7,12}};
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        for (int[] a : arr) {
            System.out.println(a[0] + " " + a[1]);
        }
    }
}
