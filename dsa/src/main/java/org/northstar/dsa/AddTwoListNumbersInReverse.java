package org.northstar.dsa;

import java.util.Stack;

/*
Given two numbers represented as two lists, the task is to return the sum of two lists.
Note: There can be leading zeros in the input lists, but there should not be any leading zeros in the output list.
Examples:
Input: num1 = 4 -> 5, num2 = 3 -> 4 -> 5
Output: 3 -> 9 -> 0
Explanation: Sum of 45 and 345 is 390.
 */
public class AddTwoListNumbersInReverse {
    //Doesnt work : 3999999999 + 7
    private static LNode addTwoListNumbersGivenInReverse(LNode l1, LNode l2) {
        int number1 = 0, number2 = 0;
        while (null != l1) {
            number1 = number1 * 10 + l1.val;
            l1 = l1.next;
        }
        while (null != l2) {
            number2 = number2 * 10 + l2.val;
            l2 = l2.next;
        }
        int number3 = number1 + number2;
        LNode dummy = new LNode();
        if(number3 == 0) {
            dummy.next = new LNode(number3);
            return dummy.next;
        }
        while(number3 != 0) {
            LNode n = new LNode(number3 % 10);
            number3 = number3 / 10;
            n.next = dummy.next;
            dummy.next = n;
        }
        return dummy.next;
    }

    public static LNode addTwoNumbers(LNode l1, LNode l2) {
        Stack<Integer> l1Stack = new Stack<>();
        Stack<Integer> l2Stack = new Stack<>();

        while(null != l1) {
            l1Stack.push(l1.val);
            l1 = l1.next;
        }
        while(null != l2) {
            l2Stack.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        LNode head = new LNode();
        while (!l1Stack.isEmpty() || !l2Stack.isEmpty() || carry != 0) {
            int digit1 = l1Stack.isEmpty() ? 0 : l1Stack.pop();
            int digit2 = l2Stack.isEmpty() ? 0 : l2Stack.pop();
            int sum = digit1 + digit2 + carry;
            carry = sum/10;
            LNode n = new LNode(sum % 10);
            n.next = head.next;
            head.next = n;
        }
        return head.next;
    }

    public static void main(String[] args) {
        // Number is 45
        LNode l11 = new LNode(4);
        l11.next = new LNode(5);
//        l11.next.next = new LNode(3);

        // Number is 345
        LNode l21 = new LNode(3);
        l21.next = new LNode(4);
        l21.next.next = new LNode(5);
        LNode r = addTwoListNumbersGivenInReverse(new LNode(0), new LNode(0));
        while(r != null) {
            System.out.print(r.val);
            r = r.next;
        }
        LNode n = addTwoNumbers(l11, l21);
        //390
        while(n != null) {
            System.out.print(n.val);
            n = n.next;
        }
        System.out.println();
        //System.out.println(3999999999 + 7);
    }
}
