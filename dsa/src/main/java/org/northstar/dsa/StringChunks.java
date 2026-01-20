package org.northstar.dsa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringChunks {

    private static List<String> y;

    public static void main(String[] args) {
        String myString = "This is a test string for chunking.";
        int chunkSize = 5;
        int numberOfChunks = (int) Math.ceil((double) 16 / chunkSize); // gives right
        int numberOfChunks1 = (int) Math.floor((double) 16 / chunkSize); //gives smaller

        System.out.println("Number of chunks: " + numberOfChunks); // Output: Number of chunks: 8 (36 characters / 5 = 7.2, rounded up to 8)
        System.out.println("Number of chunks: " + numberOfChunks1); // Output: Number of chunks: 8 (36 characters / 5 = 7.2, rounded up to 8)

        int a = 10/5;
        double b = 10.4 /4;
        System.out.println(10/5);
        System.out.println(10/4);
        System.out.println(b);

        List<String> l = new ArrayList<>();
        l.add("a");
        l.add("ab");
        l.add("abc");
        l.add("b");
        l.add("bc");
        l.add("bcd");
        List<String> x = new ArrayList<>();
        List<String> y = new ArrayList<>();
        Map<Boolean, List<String>> a1 = y.stream().collect(Collectors.partitioningBy(s -> s.startsWith("a")));
        System.out.println(a1.get(true));
        System.out.println(a1.get(false));

    }
}
