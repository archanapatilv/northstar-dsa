package org.northstar.dsa;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode temp = head, prev = null;
        while(temp.next != null) {
           ListNode next = temp.next;
           temp.next = prev;
           temp = next;
        }
        return temp;
    }
}
