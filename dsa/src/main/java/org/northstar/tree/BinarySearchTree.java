package org.northstar.tree;

import org.northstar.common.model.TreeNode;
import org.northstar.queue.LinkedQueue;
import org.northstar.queue.Queue;

import static java.lang.Math.PI;
import static java.lang.Math.max;

/**
 * value of all the nodes in left sub tree must be less or equal to root
 * value of all the nodes in right sub tree must be greater to root
 * must to true for all nodes
 *
 * each node has atmost two children
 */
public class BinarySearchTree implements Tree {
    private TreeNode root = null;
    public void insert(int data) {
        root = internalInsert(root, data);
    }
    private TreeNode internalInsert(TreeNode node, int data) {
        if(null == node) {
            node = new TreeNode(data);
        } else if (data <= (int)node.getValue()) {
            node.setLeftTree(internalInsert(node.getLeftTree(), data));
        } else {
            node.setRightTree(internalInsert(node.getRightTree(), data));
        }
        return node;
    }
    public boolean search(int data) {
        if (null == internalSearch(root, data)) {
            return false;
        } else {
            return true;
        }
    }
    private TreeNode internalSearch(TreeNode node, int data) {
        if (null == node) {
            return null;
        } else if ((int)node.getValue() == data) {
            return node;
        } else if (data < (int)node.getValue()) {
            return internalSearch(node.getLeftTree(), data);
        } else {
            return internalSearch(node.getRightTree(), data);
        }
    }
    @Override
    public int findMin() {
        return (int) internalFindMin(root).getValue();
    }
    private TreeNode internalFindMin(TreeNode node) {
        if (null == node.getLeftTree()) {
            return node;
        } else {
            return internalFindMin(node.getLeftTree());
        }
    }

    @Override
    public int findMax() {
        return (int)internalFindMax(root).getValue();
    }
    private TreeNode internalFindMax(TreeNode node) {
        if (null == node.getRightTree()) {
            return node;
        } else {
            return internalFindMax(node.getRightTree());
        }
    }

    /**
     * Height of leaf node is 0
     * Height of a node : Number of edges in the longest path from the Node to its leaf Node
     * Height of an empty tree is -1
     * Height of a tree with only root node is 0
     * @return
     */
    @Override
    public int findMaxHeight() {
        return internalFindMaxHeight(root);
    }

    private int internalFindMaxHeight(TreeNode node) {
        if (null == node) {
            return -1;
        }
        return max(internalFindMaxHeight(node.getLeftTree()), internalFindMaxHeight(node.getRightTree())) + 1;
    }

    public String bfs() throws Exception {
        if (null == root) {
            return "";
        }
        Queue<TreeNode> queue = new LinkedQueue<TreeNode>();
        queue.enqueue(root);
        StringBuilder nodes = new StringBuilder();
        while(!queue.isEmpty()) {
            TreeNode node = queue.dequeue();
            nodes.append(node.getValue()).append(" ");
            if (null != node.getLeftTree()) {
                queue.enqueue(node.getLeftTree());
            }
            if (null != node.getRightTree()) {
                queue.enqueue(node.getRightTree());
            }
        }
        return nodes.toString();
    }

    public String preOrder() {
        return dfsPreOrder(root, new StringBuilder()).toString();
    }

    @Override
    public String inOrder() {
        return dfsInOrder(root, new StringBuilder()).toString();
    }

    @Override
    public String postOrder() {
        return dfsPostOrder(root, new StringBuilder()).toString();
    }

    private StringBuilder dfsPreOrder(TreeNode root, StringBuilder nodes) {
        if(null != root) {
            nodes.append(root.getValue()).append(" ");
            dfsPreOrder(root.getLeftTree(), nodes);
            dfsPreOrder(root.getRightTree(), nodes);
        }
        return nodes;
    }

    private StringBuilder dfsInOrder(TreeNode root, StringBuilder nodes) {
        if(null != root) {
            dfsInOrder(root.getLeftTree(), nodes);
            nodes.append(root.getValue()).append(" ");
            dfsInOrder(root.getRightTree(), nodes);
        }
        return nodes;
    }

    private StringBuilder dfsPostOrder(TreeNode root, StringBuilder nodes) {
        if(null != root) {
            dfsPostOrder(root.getLeftTree(), nodes);
            dfsPostOrder(root.getRightTree(), nodes);
            nodes.append(root.getValue()).append(" ");
        }
        return nodes;
    }
    @Override
    public boolean isBST(TreeNode node) {
        if (null == node) {
            return true;
        }
        if (isLeftSubTreeLesser(node.getLeftTree(), (Integer)node.getValue()) && isRightSubTreeGreater(node.getRightTree(), (Integer)node.getValue())
                && isBST(node.getLeftTree()) && isBST(node.getRightTree())) {
            return true;
        }
        return false;
    }

    private boolean isRightSubTreeGreater(TreeNode node, Integer value) {
        if (null == node) {
            return true;
        }
        if ((Integer)node.getValue() > value
                && isRightSubTreeGreater(node.getLeftTree(), value)
                && isRightSubTreeGreater(node.getRightTree(), value)) {
            return true;
        }
        return false;
    }

    private boolean isLeftSubTreeLesser(TreeNode node, Integer value) {
        if (null == node) {
            return true;
        }
        if ((Integer)node.getValue() <= value
                && isLeftSubTreeLesser(node.getLeftTree(), value)
                && isLeftSubTreeLesser(node.getRightTree(), value)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isBST(TreeNode node, int minValue, int maxValue) {
        if (null == node) {
            return true;
        }
        if((Integer)node.getValue() >= minValue && (Integer)node.getValue() < maxValue
        && isBST(node.getLeftTree(), minValue, (Integer)node.getValue())
        && isBST(node.getRightTree(), (Integer)node.getValue(), maxValue)) {
            return true;
        }
        return false;
    }

    @Override
    public void delete(int value) {
         internalDelete(root, value);
    }

    private TreeNode internalDelete(TreeNode node, int value) {
        // No node to delete
        if (null == node) {
            return null;
        }
        // Find Node
        if(value < (Integer)node.getValue()) {
            node.setLeftTree(internalDelete(node.getLeftTree(), value));
        } else if (value > (Integer)node.getValue()) {
            node.setRightTree(internalDelete(node.getRightTree(), value));
        } else {
            //When found the node
            // check if node has no children
            if (null == node.getLeftTree() && null == node.getRightTree()) {
                node = null;
            } else if (null == node.getLeftTree()) { // Node has only left children
                node = node.getLeftTree();
            } else if (null == node.getRightTree()) { // Node has only right children
                node = node.getRightTree();
            } else { // node has both left and right children
                TreeNode minNode = internalFindMin(node.getRightTree());
                node.setValue(minNode.getValue());
                node.setRightTree(internalDelete(node.getRightTree(), (int) minNode.getValue()));
            }
        }
        return node;
    }

    @Override
    public TreeNode inOrderSuccessor(int data) {
        TreeNode node = internalSearch(root, data);
        if(null == node) {
            return null;
        }
        //If right subtree is present
        if (null != node.getRightTree()) {
            return internalFindMinInLoop(node.getRightTree());
        }
        // If there is no right subtree
        else {
            TreeNode successor = null;
            TreeNode ancestor = root;
            while (ancestor != node) {
                if((int)node.getValue() < (int) ancestor.getValue()) {
                    successor = ancestor;
                    ancestor = ancestor.getLeftTree();
                } else {
                    ancestor = ancestor.getRightTree();
                }
            }
            return successor;
        }
    }

    private TreeNode internalFindMinInLoop(TreeNode node) {
        if (null == node) {
            return null;
        }
        while (null != node.getLeftTree()) {
            node  = node.getLeftTree();
        }
        return node;
    }
}