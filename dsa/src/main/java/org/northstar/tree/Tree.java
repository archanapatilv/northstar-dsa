package org.northstar.tree;

import org.northstar.common.model.TreeNode;

public interface Tree {
    void insert(int data);
    boolean search(int data);
    int findMin();
    int findMax();
    int findMaxHeight();
    String bfs() throws Exception;
    String preOrder();
    String inOrder();
    String postOrder();
    boolean isBST(TreeNode node);
    boolean isBST(TreeNode node, int minValue, int maxValue);
    void delete(int value);
    TreeNode inOrderSuccessor(int data);
}
