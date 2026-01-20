package org.northstar.dsa;

import java.util.HashMap;
import java.util.Map;

public class PathSumIIIBinaryTree {
    static int count = 0;
    static Map<Long, Integer> h = new HashMap();
    static public int pathSum(TreeNode root, int targetSum) {
        if(null == root) {
            return 0;
        }
       // _pathSum(root, targetSum, 0);
        return count;
    }

    static private void preOrder(TreeNode node, long currentSum, int targetSum) {
        if(node == null) {
            return;
        }
        currentSum += node.val;
        if(currentSum == targetSum ) {
            count++;
        }

        // The number of times the curr_sum − k has occurred already,
        // determines the number of times a path with sum k
        // has occurred up to the current node
        count += h.getOrDefault(currentSum - targetSum, 0);

        //Add the current sum into the hashmap
        // to use it during the child node's processing
        h.put(currentSum, h.getOrDefault(currentSum, 0) + 1);
        // Process the left subtree
        preOrder(node.left, currentSum, targetSum);

        // Process the right subtree
        preOrder(node.right, currentSum, targetSum);

        // Remove the current sum from the hashmap
        // in order not to use it during
        // the parallel subtree processing
        h.put(currentSum, h.get(currentSum) - 1);
    }

    static private void _pathSum(TreeNode node, int targetSum, int currentSum) {
        currentSum += node.val;
        if(node.val == targetSum || currentSum == targetSum) {
            count++;
            currentSum = 0;
        }
        if(currentSum > targetSum) {
            currentSum = 0;
        }
        if (null != node.left) {
            _pathSum(node.left, targetSum, currentSum);
        }
        if(null != node.right) {
            _pathSum(node.right, targetSum, currentSum);
        }
    }
    public static void main(String[] args) {
        //[5,4,8,11,null,13,4,7,2,null,null,5,1]
   //                     5
   //            4                 8
   //       11      null      13          4
   //     7   2                          5   1
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.right.left = new TreeNode(13);

        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
    }
}
