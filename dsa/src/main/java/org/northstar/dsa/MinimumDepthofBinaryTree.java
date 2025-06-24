package org.northstar.dsa;

public class MinimumDepthofBinaryTree {

    public static int minDepthOfBinaryTree(TreeNode node) {
        if (null == node) {
            return 0;
        }
        int left = minDepthOfBinaryTree(node.left);
        int right = minDepthOfBinaryTree(node.right);
        if (0 == left || 0 == right) {
            return left + right + 1;
        } else {
            return Math.min(left, right) + 1;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(20);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(7);

        root.left = n1;
        root.right = n2;
        n2.left = n3;
        n2.right = n4;

        System.out.println("Min Depth : " + minDepthOfBinaryTree(root));
        TreeNode mroot = new TreeNode(2);
        TreeNode m1 = new TreeNode(3);
        TreeNode m2 = new TreeNode(4);
        TreeNode m3 = new TreeNode(5);
        TreeNode m4 = new TreeNode(6);
        mroot.right = m1;
        m1.right = m2;
        m2.right = m3;
        m3.right = m4;
        System.out.println("Min Depth : " + minDepthOfBinaryTree(mroot));



    }
}
