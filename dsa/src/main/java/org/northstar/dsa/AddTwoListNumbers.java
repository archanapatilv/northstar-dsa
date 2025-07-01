package org.northstar.dsa;

public class AddTwoListNumbers {

    public static LNode addTwoListNumbers(LNode l1, LNode l2) {
        LNode result = null;
        if (null == l1 || null == l2) {
            return  result;
        }
        int carry = 0;
        result = new LNode(0);
        LNode temp = result;
        while (l1 != null || l2 != null || carry != 0) {
            int a = null == l1 ? 0 : l1.val;
            int b = null == l2 ? 0 : l2.val;
            int sum = a + b + carry;
            temp.next = new LNode(sum % 10);
            carry = sum / 10;
            temp = temp.next;
            l1 = null == l1 ? l1: l1.next;
            l2 = null == l2 ? l2: l2.next;
        }
        return result.next;
    }


    public static void main(String[] args) {
        // Number is 342
        LNode l11 = new LNode(2);
        l11.next = new LNode(4);
        l11.next.next = new LNode(3);

        // Number is 465
        LNode l21 = new LNode(5);
        l21.next = new LNode(6);
        l21.next.next = new LNode(4);
        LNode n = addTwoListNumbers(l11, l21);
        //708 (reverse order)
        while(n != null) {
            System.out.print(n.val);
            n = n.next;
        }
    }
}
 class LNode {
     int val;
     LNode next;

     LNode() {
     }

     LNode(int val) {
         this.val = val;
     }

     LNode(int val, LNode next) {
         this.val = val;
         this.next = next;
     }
 }

