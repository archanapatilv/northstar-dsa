package org.northstar.tree;

import org.northstar.common.model.TreeNode;

public class LargestBSTInABinaryTree {
    public static void main(String[] args) {
        LargestBSTInABinaryTree lbi = new LargestBSTInABinaryTree();

        TreeNode root = new TreeNode(25);
        root.setLeftTree(new TreeNode(18));
        root.setRightTree(new TreeNode(50));

        root.getLeftTree().setLeftTree(new TreeNode(19));
        root.getLeftTree().getLeftTree().setRightTree(new TreeNode(15));

        root.getLeftTree().setRightTree(new TreeNode(20));
        root.getLeftTree().getRightTree().setLeftTree(new TreeNode(18));
        root.getLeftTree().getRightTree().setRightTree(new TreeNode(25));

        root.getRightTree().setLeftTree(new TreeNode(35));;
        root.getRightTree().getLeftTree().setLeftTree(new TreeNode(20));
        root.getRightTree().getLeftTree().getLeftTree().setRightTree(new TreeNode(25));
        root.getRightTree().getLeftTree().setRightTree(new TreeNode(40));

        root.getRightTree().setRightTree(new TreeNode(60));
        root.getRightTree().getRightTree().setLeftTree(new TreeNode(55));
        root.getRightTree().getRightTree().setRightTree(new TreeNode(70));

        BTreeMetaData largestBSTSize = lbi.largestBST(root);
        System.out.println("Size of largest BST  is " + largestBSTSize.count);
        assert largestBSTSize.count == 8;
    }

    public BTreeMetaData largestBST(TreeNode<Integer> node) {
        if (null == node) {
            return new BTreeMetaData();
        }
        BTreeMetaData bTreeMetaDataLeft = largestBST(node.getLeftTree());
        BTreeMetaData bTreeMetaDataRight = largestBST(node.getRightTree());

        BTreeMetaData bTreeMetaData = new BTreeMetaData();

        //If any one is false, the whole left, right with root will not ba BST
        // or if root data is not greater than left and not lesser than right
        if(!bTreeMetaDataLeft.isBST
                || !bTreeMetaDataRight.isBST
                || (null != node.getLeftTree() && bTreeMetaDataLeft.max > node.getValue()
                ||  null != node.getRightTree() &&  bTreeMetaDataRight.min <= node.getValue())) {
            bTreeMetaData.isBST = false;
            bTreeMetaData.count = Math.max(bTreeMetaDataLeft.count, bTreeMetaDataRight.count);
            return bTreeMetaData;
        }
        bTreeMetaData.isBST = true;
        // if everthing is fine then add both left, right and center to get the count;
        bTreeMetaData.count = bTreeMetaDataLeft.count + bTreeMetaDataRight.count + 1;

        //if left tree was null, then use root data as min value
        bTreeMetaData.min = null == node.getLeftTree() ? node.getValue() : bTreeMetaDataLeft.min;
        //IF right node is null, then use root data as max value
        bTreeMetaData.max = null == node.getRightTree() ? node.getValue() : bTreeMetaDataRight.max;
        return bTreeMetaData;
    }
}

class BTreeMetaData {
    int count;
    int min;
    int max;
    boolean isBST;
    BTreeMetaData() {
        count = 0;
        min = Integer.MIN_VALUE;
        max = Integer.MAX_VALUE;
        isBST = true;
    }
}