package org.northstar.dsa;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

//Time : O(n) space O(nlogn)
/*
This approach:
Counts the length of the linked list.
Recursively builds the BST using the in-order traversal simulation.
*/
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}
public class ConvertSortedLinkedListToBST {
    private ListNode head;

    public TreeNode convertLinkedListToBST(ListNode listNode) {
        this.head = listNode;
        //Get the length of the list
        ListNode temp = listNode;
        int size = 0;
        while(temp != null) { // n times
            temp = temp.next;
            size++;
        }
        return buildBST(0, size-1);
    }

    private TreeNode buildBST(int left, int right) {
        if (left > right) return null;

        int mid = left + (right - left) / 2;

        // Recursively build the left subtree
        TreeNode leftChild = buildBST(left, mid - 1);

        // The current head node is the root
        TreeNode root = new TreeNode(head.val);
        root.left = leftChild;

        // Move to the next list node
        head = head.next;

        // Recursively build the right subtree
        root.right = buildBST(mid + 1, right);

        return root;
    }

     private TreeNode generateBST(int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode(head.val);
        int mid = left + (right-left)/2;
        root.left = generateBST(left, mid-1);
        head = head.next;
        root.right = generateBST(mid+1, right);
        return root;
    }

    private void printBFS(TreeNode node) {
        if (null == node)
            return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()) {
            TreeNode n = q.poll();
            System.out.print( n.val + " ");
            if(null != n.left) {
                q.add(n.left);
            }
            if(null != n.right) {
                q.add(n.right);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        -10,-3,0,5,9
        ListNode head = new ListNode(-10);
        ListNode l2 = new ListNode(-3);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(9);
        head.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ConvertSortedLinkedListToBST cSLBST = new ConvertSortedLinkedListToBST();
        TreeNode root = cSLBST.convertLinkedListToBST(head);
        cSLBST.printBFS(root);
    }
}
