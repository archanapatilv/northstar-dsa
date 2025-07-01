package org.northstar.dsa;

public class SumRootToLeafNumbers {
    static int total = 0;
    public static void sumNumbers(TreeNode root, int currentNumber) {
        if(null != root) {
            currentNumber = currentNumber * 10 + root.val;
            if (null == root.left && null == root.right) {
                total += currentNumber;
            }
            sumNumbers(root.left, currentNumber);
            sumNumbers(root.right, currentNumber);
        }
    }

    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(1);
        r1.left = new TreeNode(2);
        r1.right = new TreeNode(3);
        sumNumbers(r1, 0);
        System.out.println(total);
        TreeNode r2 = new TreeNode(4);
        r2.left = new TreeNode(9);
        r2.right = new TreeNode(0);
        r2.left.left = new TreeNode(5);
        r2.left.right = new TreeNode(1);
        total = 0;
        sumNumbers(r2, 0);
        System.out.println(total);
    }
}
