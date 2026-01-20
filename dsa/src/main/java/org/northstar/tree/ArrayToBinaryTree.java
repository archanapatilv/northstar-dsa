package org.northstar.tree;

import org.northstar.common.model.TreeNode;

public class ArrayToBinaryTree {


    public TreeNode createBinaryTree(int[] arr) {
        return _createBinaryTree(arr, arr.length, 0);
    }

    private TreeNode _createBinaryTree(int[] arr, int length, int i) {
        if(i < 0 || i >= length) {
            return null;
        }
        TreeNode node = new TreeNode(arr[i]);
        node.setLeftTree(_createBinaryTree(arr, length, (2*i)+1 ));
        node.setRightTree(_createBinaryTree(arr, length, (2*i)+2 ));
        return node;
    }

    public static void main(String[] args) {
        ArrayToBinaryTree arrayToBinaryTree = new ArrayToBinaryTree();
        TreeNode node =  arrayToBinaryTree.createBinaryTree(new int[]{0,1,2,3,4,5,6,7,8,9});
        TreeTraversal treeTraversal = new TreeTraversal();
        treeTraversal.preorder(node);
    }
}
