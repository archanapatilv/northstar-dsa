package org.northstar.tree;

import org.junit.Assert;
import org.junit.Test;
import org.northstar.common.model.TreeNode;

public class BinarySearchTreeTest {
    @Test
    public void testCreate() {
        Tree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(15);
        bst.insert(20);
        bst.insert(25);
        bst.insert(8);
        bst.insert(12);
        Assert.assertTrue(bst.search(10));
        Assert.assertTrue(bst.search(15));
        Assert.assertTrue(bst.search(20));
        Assert.assertTrue(bst.search(25));
        Assert.assertTrue(bst.search(8));
        Assert.assertTrue(bst.search(12));
        Assert.assertFalse(bst.search(11));
    }

    @Test
    public void testFindMin() {
        Tree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(15);
        bst.insert(20);
        bst.insert(25);
        bst.insert(8);
        bst.insert(12);
        Assert.assertEquals(8, bst.findMin());
    }

    @Test
    public void testFindMax() {
        Tree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(15);
        bst.insert(20);
        bst.insert(25);
        bst.insert(8);
        bst.insert(12);
        Assert.assertEquals(25, bst.findMax());
    }

    @Test
    public void testMaxHeight() {
        Tree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(15);
        bst.insert(20);
        bst.insert(25);
        bst.insert(8);
        bst.insert(12);
        Assert.assertEquals(3, bst.findMaxHeight());
    }

    @Test
    public void testMaxHeightWithOnlyRoot() {
        Tree bst = new BinarySearchTree();
        bst.insert(10);
        Assert.assertEquals(0, bst.findMaxHeight());
    }

    @Test
    public void testMaxHeightWithTwoNodes() {
        Tree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(15);
        Assert.assertEquals(1, bst.findMaxHeight());
    }

    @Test
    public void testMaxHeightEmptyTree() {
        Tree bst = new BinarySearchTree();
        Assert.assertEquals(-1, bst.findMaxHeight());
    }

    @Test
    public void testBFS() throws Exception {
        Tree bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(30);
        bst.insert(90);
        bst.insert(15);
        bst.insert(38);
        bst.insert(72);
        bst.insert(70);
        bst.insert(60);
        Assert.assertEquals("50 30 90 15 38 72 70 60 ", bst.bfs());
    }

    @Test
    public void testPreorder() throws Exception {
        Tree bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(30);
        bst.insert(90);
        bst.insert(15);
        bst.insert(38);
        bst.insert(72);
        bst.insert(70);
        bst.insert(60);
        Assert.assertEquals("50 30 15 38 90 72 70 60 ", bst.preOrder());
    }

    @Test
    public void testInorder() throws Exception {
        Tree bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(30);
        bst.insert(90);
        bst.insert(15);
        bst.insert(38);
        bst.insert(72);
        bst.insert(70);
        bst.insert(60);
        Assert.assertEquals("15 30 38 50 60 70 72 90 ", bst.inOrder());
    }

    /*
                      50
          30                      90
  15          38              72
                          70
                      60
   */
    @Test
    public void testPostOrder() throws Exception {
        Tree bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(30);
        bst.insert(90);
        bst.insert(15);
        bst.insert(38);
        bst.insert(72);
        bst.insert(70);
        bst.insert(60);
        Assert.assertEquals("15 38 30 60 70 72 90 50 ", bst.postOrder());
    }

    @Test
    public void testIsBST() {
        TreeNode root = new TreeNode<>(8);
        TreeNode node1 = new TreeNode<>(6);
        TreeNode node2 = new TreeNode<>(4);
        root.setLeftTree(node1);
        node1.setLeftTree(node2);
        Assert.assertTrue(new BinarySearchTree().isBST(root));
    }

    @Test
    public void testIsBST1() {
        TreeNode root = new TreeNode<>(10);
        TreeNode node1 = new TreeNode<>(5);
        TreeNode node2 = new TreeNode<>(16);
        TreeNode node3 = new TreeNode<>(4);
        TreeNode node4 = new TreeNode<>(7);
        TreeNode node5 = new TreeNode<>(1);
        TreeNode node6 = new TreeNode<>(11);
        root.setLeftTree(node1);
        root.setRightTree(node2);
        node1.setLeftTree(node3);
        node1.setLeftTree(node4);
        node3.setLeftTree(node5);
        node4.setRightTree(node6);
        Assert.assertFalse(new BinarySearchTree().isBST(root));
    }

    @Test
    public void testIsBST2() {
        TreeNode root = new TreeNode<>(7);
        TreeNode node1 = new TreeNode<>(4);
        TreeNode node2 = new TreeNode<>(9);
        TreeNode node3 = new TreeNode<>(1);
        TreeNode node4 = new TreeNode<>(6);
        root.setLeftTree(node1);
        root.setRightTree(node2);
        node1.setLeftTree(node3);
        node1.setRightTree(node4);
        Assert.assertTrue(new BinarySearchTree().isBST(root));
    }
    @Test
    public void testIsBST3() {
        TreeNode root = new TreeNode<>(5);
        TreeNode node1 = new TreeNode<>(1);
        TreeNode node2 = new TreeNode<>(8);
        TreeNode node3 = new TreeNode<>(9);
        TreeNode node4 = new TreeNode<>(12);
        root.setLeftTree(node1);
        root.setRightTree(node2);
        node2.setLeftTree(node3);
        node2.setRightTree(node4);
        Assert.assertFalse(new BinarySearchTree().isBST(root));
    }

    @Test
    public void testIsBSTWithRange() {
        TreeNode root = new TreeNode<>(8);
        TreeNode node1 = new TreeNode<>(6);
        TreeNode node2 = new TreeNode<>(4);
        root.setLeftTree(node1);
        node1.setLeftTree(node2);
        Assert.assertTrue(new BinarySearchTree().isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    @Test
    public void testIsBSTWithRange1() {
        TreeNode root = new TreeNode<>(10);
        TreeNode node1 = new TreeNode<>(5);
        TreeNode node2 = new TreeNode<>(16);
        TreeNode node3 = new TreeNode<>(4);
        TreeNode node4 = new TreeNode<>(7);
        TreeNode node5 = new TreeNode<>(1);
        TreeNode node6 = new TreeNode<>(11);
        root.setLeftTree(node1);
        root.setRightTree(node2);
        node1.setLeftTree(node3);
        node1.setLeftTree(node4);
        node3.setLeftTree(node5);
        node4.setRightTree(node6);
        Assert.assertFalse(new BinarySearchTree().isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    @Test
    public void testIsBSTWithRange2() {
        TreeNode root = new TreeNode<>(7);
        TreeNode node1 = new TreeNode<>(4);
        TreeNode node2 = new TreeNode<>(9);
        TreeNode node3 = new TreeNode<>(1);
        TreeNode node4 = new TreeNode<>(6);
        root.setLeftTree(node1);
        root.setRightTree(node2);
        node1.setLeftTree(node3);
        node1.setRightTree(node4);
        Assert.assertTrue(new BinarySearchTree().isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
    @Test
    public void testIsBSTWithRange3() {
        TreeNode root = new TreeNode<>(5);
        TreeNode node1 = new TreeNode<>(1);
        TreeNode node2 = new TreeNode<>(8);
        TreeNode node3 = new TreeNode<>(9);
        TreeNode node4 = new TreeNode<>(12);
        root.setLeftTree(node1);
        root.setRightTree(node2);
        node2.setLeftTree(node3);
        node2.setRightTree(node4);
        Assert.assertFalse(new BinarySearchTree().isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
/*
                                12
                5                           15
        3               7           13              17
    1                       9

                                12
                5                           17
        3               7            13
    1                       9

 */
    @Test
    public void testDelete() {
        Tree bst = new BinarySearchTree();
        bst.insert(12);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.insert(13);
        bst.insert(17);
        bst.insert(1);
        bst.insert(9);
        Assert.assertEquals("12 5 3 1 7 9 15 13 17 ", bst.preOrder());
        bst.delete(15);
        Assert.assertFalse(bst.search(15));
        Assert.assertEquals("12 5 3 1 7 9 17 13 ", bst.preOrder());
    }

    @Test
    public void testInOrderSuccessor() {
        Tree bst = new BinarySearchTree();
        bst.insert(15);
        bst.insert(10);
        bst.insert(20);
        bst.insert(8);
        bst.insert(12);
        bst.insert(17);
        bst.insert(25);
        bst.insert(6);
        bst.insert(11);
        bst.insert(16);
        bst.insert(27);
        Assert.assertEquals(15, bst.inOrderSuccessor(12).getValue());
        Assert.assertEquals(8, bst.inOrderSuccessor(6).getValue());
        Assert.assertEquals(27, bst.inOrderSuccessor(25).getValue());
        Assert.assertEquals(25, bst.inOrderSuccessor(20).getValue());
        Assert.assertEquals(null, bst.inOrderSuccessor(27));
    }
}
