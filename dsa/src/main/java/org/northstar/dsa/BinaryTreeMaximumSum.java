package org.northstar.dsa;

/*
Time complexity : O(n)
n is number of nodes in the binary tree.
 */
public class BinaryTreeMaximumSum {

    static int maxSum = 0;
    public static int maxPathSum(TreeNode treeNode) {
        _maxPathSum(treeNode);
        return maxSum;
    }

    public static int _maxPathSum(TreeNode root) {

        if (null == root) {
            return 0;
        }
        if(null == root.left && null == root.right)  {
            return root.val;
        }
        int left = _maxPathSum(root.left);
        maxSum = Math.max(maxSum, left);
        int right = _maxPathSum(root.right);
        maxSum = Math.max(maxSum, right);
        int sum = left + right + root.val;
        maxSum = Math.max(maxSum, sum);
        return Math.max(root.val, Math.max(left, right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        root.left = n1;
        root.right = n2;
        System.out.println("The max Sum is : " + maxPathSum(root));

        TreeNode r1 = new TreeNode(-10);
        TreeNode rn1 = new TreeNode(9);
        TreeNode rn2 = new TreeNode(20);
        TreeNode rn3 = new TreeNode(15);
        TreeNode rn4 = new TreeNode(7);
        r1.left = rn1;
        r1.right = rn2;
        rn2.left = rn3;
        rn2.right = rn4;
        System.out.println("The max Sum is : " + maxPathSum(r1));

    }
}
