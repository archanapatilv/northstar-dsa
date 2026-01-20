package org.northstar.dsa;

import java.util.Stack;

public class StringDecoding {

    //2[ab]
    static String decode(String s) {
        StringBuffer result = new StringBuffer();
        Stack<Character> stack = new Stack<>();
        char open = '[';
        char close = ']';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c != close) {
                stack.push(c);
            } else {
                StringBuffer temp = new StringBuffer();
                while(stack.peek() != open) {
                    temp.insert(0, stack.pop());
                }
                stack.pop();// to remove [ bracket
                StringBuffer tempDigit = new StringBuffer();
                while(!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    tempDigit.insert(0, stack.pop());
                }
                int digit = Integer.parseInt(tempDigit.toString());
                while(digit > 0) {
                    String sStr = temp.toString();
                    for(int k = 0; k < sStr.length(); k++) {
                        stack.push(sStr.charAt(k));
                    }
                    digit--;
                }
            }
        }
        while(!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println("Decode String of 2[abc]df : " + decode("xy2[abc]df"));
    }
}
