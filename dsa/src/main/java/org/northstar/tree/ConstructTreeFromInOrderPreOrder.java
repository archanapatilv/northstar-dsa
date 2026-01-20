package org.northstar.tree;

import org.northstar.common.model.TreeNode;

public class ConstructTreeFromInOrderPreOrder {

    private int index = 0;
    public TreeNode createTree(int inorder[], int preorder[]){
        TreeNode result =  createTree(inorder,preorder,0,inorder.length-1);
        index = 0;
        return result;
    }

    private TreeNode createTree(int inorder[],int preorder[], int start, int end){
        if(start > end){
            return null;
        }
        int i;
        for(i=start; i <= end; i++){
            if(preorder[index] == inorder[i]){
                break;
            }
        }
        TreeNode node = new TreeNode(preorder[index]);
        index++;
        node.setLeftTree(createTree(inorder,preorder,start,i-1));
        node.setRightTree(createTree(inorder,preorder,i+1,end));
        return node;
    }
}
