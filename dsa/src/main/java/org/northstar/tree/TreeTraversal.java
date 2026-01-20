package org.northstar.tree;

import org.northstar.common.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversal {

    //Recursive
    public void preorder(TreeNode node) {
        if(null != node) {
            System.out.println(node.getValue());
            preorder(node.getLeftTree());
            preorder(node.getRightTree());
        }
    }
    public void inorder(TreeNode node) {
        if(null != node) {
            inorder(node.getLeftTree());
            System.out.println(node.getValue());
            inorder(node.getRightTree());
        }
    }
    public void postorder(TreeNode node) {
        if(null != node) {
            postorder(node.getLeftTree());
            postorder(node.getRightTree());
            System.out.println(node.getValue());
        }
    }

    // Iterative
    public void postOrder(TreeNode node) {
        if(null == node) {
            return;
        }
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(node);
        while(!stack1.isEmpty()) {
            TreeNode n = stack1.pop();
            stack2.push(n);
            if(null != n.getLeftTree()) {
                stack1.push(n.getLeftTree());
            }
            if(null != n.getRightTree()) {
                stack1.push(n.getRightTree());
            }
        }
        while(!stack2.isEmpty()) {
            System.out.print(stack2.pop().getValue() + " ");
        }
    }
    public void preOrder(TreeNode node) {
        if(null == node) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(node);
        while(!stack.isEmpty()) {
            TreeNode n = stack.pop();
            System.out.print(n.getValue() + " ");
            if(null != n.getRightTree()) {
                stack.push(n.getRightTree());
            }
            if(null != n.getLeftTree()) {
                stack.push(n.getLeftTree());
            }
        }
    }

    public void inOrder(TreeNode node) {
        if(null == node) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(true) {
            if(null != node) {
                stack.push(node);
                node = node.getLeftTree();
            } else {
                if(stack.isEmpty()) {
                   return;
                }
                node = stack.pop();
                System.out.println(node.getValue());
                node = node.getRightTree();
            }
        }
    }

    public void levelByLevelPrint(TreeNode node) {
        if(null == node) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                System.out.println(queue.poll().getValue());
            }
            if (null != node.getLeftTree()) {
                queue.offer(node.getLeftTree());
            }
            if (null != node.getRightTree()) {
                queue.offer(node.getRightTree());
            }
        }
    }

    public void levelOrderReversePrinting(TreeNode node) {
        if(null == node) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        queue.offer(node);
        while(!queue.isEmpty()) {
            TreeNode n = queue.poll();
            stack.push(n);
            if(null != n.getRightTree()) {
                queue.offer(n.getRightTree());
            }
            if(null != n.getLeftTree()) {
                queue.offer(n.getLeftTree());
            }
        }
        while(!stack.isEmpty()) {
            System.out.println(stack.pop().getValue());
        }
    }

    public void spiralPrintingTwoStack(TreeNode node) {
        if(null == node) {
            return;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(node);
        while(!s1.isEmpty() || !s2.isEmpty()) {
            while(!s1.isEmpty()) {
                TreeNode n = s1.pop();
                System.out.print( n.getValue() + " ");
                if(null != n.getLeftTree()) {
                    s2.push(n.getLeftTree());
                }
                if(null != n.getRightTree()) {
                    s2.push(n.getRightTree());
                }
            }
            while(!s2.isEmpty()) {
                TreeNode n = s2.pop();
                System.out.print( n.getValue() + " ");

                //Right First cos of spiral
                if(null != n.getRightTree()) {
                    s1.push(n.getRightTree());
                }
                if(null != n.getLeftTree()) {
                    s1.push(n.getLeftTree());
                }
            }
        }
    }


    public TreeNode lowestCommonAncestorInBinaryTree(TreeNode root, TreeNode p, TreeNode q) {
        if(null == root || null == p || null == q) {
            return root;
        }
        if(root.getValue().equals(p.getValue()) || root.getValue().equals(q.getValue())) {
            return root;
        }
        TreeNode leftSide = lowestCommonAncestorInBinaryTree(root.getLeftTree(), p, q);
        TreeNode rightSide = lowestCommonAncestorInBinaryTree(root.getRightTree(), p, q);
        if(null != leftSide && null != rightSide) {
            return root;
        }
        if(null == leftSide) {
            return rightSide;
        }
        return leftSide;
    }

    public TreeNode lowestCommonAncestorInBinarySearchTree(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        if (null == root || null == p || null == q) {
            return root;
        }
        if (root.getValue() > Math.max(p.getValue(), q.getValue())) {
            return lowestCommonAncestorInBinarySearchTree(root.getLeftTree(), p, q);
        } else if (root.getValue() < Math.min(p.getValue(), q.getValue())) {
            return lowestCommonAncestorInBinarySearchTree(root.getRightTree(), p, q);
        } else {
            return root;
        }
    }

}
