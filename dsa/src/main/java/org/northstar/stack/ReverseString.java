package org.northstar.stack;

import java.nio.charset.StandardCharsets;

public class ReverseString {
    public static void main(String[] args) throws Exception {
        String test = "test";
        printReverse(test);
        System.out.println();
        System.out.println(reverse(test));
    }

    private static void printReverse(String test) throws Exception {
        Stack<Character> stack = new LinkedStack<>();
        char[] arr = test.toCharArray();
        for (char a: arr) {
            stack.push(a);
        }
        while(!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }

    private static String reverse(String test) throws Exception {
        Stack<Character> stack = new LinkedStack<>();
        char[] arr = test.toCharArray();
        for (char a: arr) {
            stack.push(a);
        }
        int i = 0;
        while(!stack.isEmpty()) {
            arr[i++] = stack.pop();
        }
        return String.copyValueOf(arr);
    }
}