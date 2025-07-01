package org.northstar.dsa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalToPrint {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(null == root) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int nodeCount = queue.size();
            List<Integer> currentSequence = new ArrayList<>();
            for (int i = 0; i < nodeCount; i++) {
                TreeNode node = queue.poll();
                currentSequence.add(node.val);
                if(null != node.left) {
                    queue.add(node.left);
                }
                if(null != node.right) {
                    queue.add(node.right);
                }
            }
            result.add(currentSequence);
        }
        return result;
    }

    public static void main(String[] args) {
        // Binary Tree Representation
        //
        //       1
        //     /   \
        //    2     3
        //   / \
        //  4   5

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(levelOrder(root));

        //Input: root = [3,9,20,null,null,15,7]
        //Output: [[3],[9,20],[15,7]]
        TreeNode r1 = new TreeNode(3);
        r1.left = new TreeNode(9);
        r1.right = new TreeNode(20);
        r1.right.left = new TreeNode((15));
        r1.right.right = new TreeNode((7));
        System.out.println(levelOrder(r1));

        //Input: root = [1]
        //Output: [[1]]
        TreeNode r2 = new TreeNode(1);
        System.out.println(levelOrder(r2));


        //Input: root = []
        //Output: []
        System.out.println(levelOrder(null));
    }
}
