package org.northstar.dsa;

public class CountGoodNodesBinaryTree {

    static int count = 0;

    static public int goodNodes(TreeNode root) {
        if(null == root) {
            return count;
        }
        _goodNodes(root, Integer.MIN_VALUE);
        return  count;
    }

    private static void _goodNodes(TreeNode node, int max) {
        if(node.val >= max) {
            count++;
        }
        if(null != node.left) {
            _goodNodes(node.left, Math.max(max, node.val));
        }
        if(null != node.right) {
            _goodNodes(node.right, Math.max(max, node.val));
        }
    }

    public static void main(String[] args) {
        //[3,1,4,3,null,1,5]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        System.out.println("Good Nodes count: " + goodNodes(root));
    }
}
