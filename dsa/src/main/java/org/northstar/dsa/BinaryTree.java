package org.northstar.dsa;

public class BinaryTree {
    int val;
    BinaryTree left;
    BinaryTree right;

    BinaryTree(int val) {
        this.val = val;
    }

    public BinaryTree delete(BinaryTree root, int val) {
        if(null == root) {
            return root;
        }
        if(val < root.val) {
            root.left = delete(root.left, val);
        } else if(val > root.val) {
            root.right = delete(root.right, val);
        } else {
            if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            } else {
                root.val = minValueNode(root.right);
                root.right = delete(root.right, root.val);
            }
        }
        return root;
    }

    private int minValueNode(BinaryTree node) {
        while(node.left != null) {
            node = node.left;
        }
        return node.val;
    }

    public BinaryTree insert(BinaryTree root, int val) {
        BinaryTree node = new BinaryTree(val);
        BinaryTree temp = root;
        while(null != temp) {
            if(temp.val >= val) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        if(null == temp) {
            root = node;
        } else if(val <= temp.val) {
            temp.left = node;
        } else {
            temp.right = node;
        }
        return root;
    }
}