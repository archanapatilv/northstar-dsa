package org.northstar.dsa;

public class OddEvenList {
    static public ListNode oddEvenList(ListNode head) {
        if(null == head || null == head.next || null == head.next.next) {
            return head;
        }
        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode prevOddNode = oddNode;
        ListNode prevEvenNode = evenNode;
        ListNode tempEvenNode = evenNode;
        //oddNode != null && oddNode.next != null &&
        while(evenNode != null && evenNode.next != null) {
            oddNode = oddNode.next.next;
            evenNode = evenNode.next.next;
            prevOddNode.next = oddNode;
            tempEvenNode.next = evenNode;
            prevOddNode = prevOddNode.next;
            tempEvenNode = tempEvenNode.next;
        }
        prevOddNode.next = prevEvenNode;
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        ListNode res = oddEvenList(l1);
        while(res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
