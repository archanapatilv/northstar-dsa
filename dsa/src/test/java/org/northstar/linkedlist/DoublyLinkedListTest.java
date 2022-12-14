package org.northstar.linkedlist;

import org.junit.Assert;
import org.junit.Test;

public class DoublyLinkedListTest {
    @Test
    public void testListEmpty(){
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void testListInsert() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insert(10);
        Assert.assertEquals(1, list.getSize());
        Assert.assertEquals(true, list.contains(10));
    }

    @Test
    public void testListInsertMultiple() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insert(10);
        list.insert(20);
        Assert.assertEquals(2, list.getSize());
        Assert.assertEquals(true, list.contains(10));
        Assert.assertEquals(true, list.contains(20));
    }

    @Test
    public void testListInsertDuplicate() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insert(10);
        list.insert(10);
        list.insert(20);
        list.insert(10);
        Assert.assertEquals(4, list.getSize());
        Assert.assertEquals(true, list.contains(10));
    }

    @Test
    public void testListInsertAtFirstPosition() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insert(10);
        list.insert(20, 1);
        Assert.assertEquals(2, list.getSize());
        Assert.assertEquals(true, list.contains(20));
        Assert.assertEquals(true, list.contains(10));
    }

    @Test
    public void testListInsertAtSecondPosition() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insert(10);
        list.insert(20, 2);
        Assert.assertEquals(2, list.getSize());
        Assert.assertEquals(true, list.contains(20));
        Assert.assertEquals(true, list.contains(10));
    }

    @Test
    public void testListInsertAtLastPosition() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insert(10);
        list.insert(20, 2);
        list.insert(30);
        list.insert(40, 4);
        list.insert(50);
        list.insert(60, 6);
        Assert.assertEquals(6, list.getSize());
        Assert.assertEquals(true, list.contains(60));
    }

    @Test
    public void testListInsertAtDuplicateValues() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insert(10);
        list.insert(10, 1);
        list.insert(10, 2);
        Assert.assertEquals(3, list.getSize());
        Assert.assertEquals(true, list.contains(10));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testInsertInvalidPositionOnEmptyList(){
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insert(10, -1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testInsertInvalidPositionZeroOnEmptyList(){
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insert(10, 0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testInsertInvalidPositionListSizeOne(){
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insert(10);
        list.insert(20, 3);
    }

    @Test
    public void testListContainsOnEmptyList() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        Assert.assertFalse(list.contains(10));
    }

    @Test
    public void testListContainsOnListSizeOne() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insert(10);
        Assert.assertTrue(list.contains(10));
    }

    @Test
    public void testListContainsHavingMultipleValues() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insert(10);
        list.insert(30);
        list.insert(90);
        Assert.assertTrue(list.contains(30));
        Assert.assertTrue(list.contains(90));
        Assert.assertTrue(list.contains(10));
    }

    @Test
    public void testListContainsHavingDuplicateValues() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insert(10);
        list.insert(30);
        list.insert(90);
        list.insert(30);
        Assert.assertTrue(list.contains(30));
        Assert.assertTrue(list.contains(90));
        Assert.assertTrue(list.contains(10));
    }

    @Test (expected = IllegalStateException.class)
    public void testDeleteInEmptyList() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.delete(10);
    }

    @Test
    public void testDeleteListOfSizeOne() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insert(10);
        list.delete(10);
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void testDeleteListOfSizeOneWithValueDoesNotExist() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insert(10);
        list.delete(20);
        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void testDeleteListWithMultipleValues() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);
        list.delete(20);
        Assert.assertEquals(4, list.getSize());
        Assert.assertFalse(list.contains(20));
        Assert.assertTrue(list.contains(10));
        Assert.assertTrue(list.contains(30));
        Assert.assertTrue(list.contains(40));
        Assert.assertTrue(list.contains(50));
    }

    @Test
    public void testDeleteListLastValueWithMultipleValues() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);
        list.delete(10);
        Assert.assertEquals(4, list.getSize());
        Assert.assertFalse(list.contains(10));
        Assert.assertTrue(list.contains(20));
        Assert.assertTrue(list.contains(30));
        Assert.assertTrue(list.contains(40));
        Assert.assertTrue(list.contains(50));
    }

    @Test
    public void testDeleteListAll() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);
        list.delete(20);
        list.delete(40);
        list.delete(10);
        list.delete(50);
        list.delete(30);
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void testDeleteListHavingDuplicates() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insert(10);
        list.insert(20);
        list.insert(10);
        list.insert(20);
        list.insert(50);
        list.delete(10);
        Assert.assertEquals(4, list.getSize());
    }

    @Test
    public void testGetAtFirstIndexHavingOneValue() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        Integer insertValue = 10;
        list.insert(insertValue);
        Integer value = list.get(1);
        Assert.assertEquals(insertValue, value);
    }

    @Test
    public void testGetAtFirstIndexHavingTwoValues() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        Integer insertValue1 = 10;
        Integer insertValue2 = 20;
        list.insert(insertValue1);
        list.insert(insertValue2);
        Integer value = list.get(1);
        Assert.assertEquals(insertValue2, value);
        value = list.get(2);
        Assert.assertEquals(insertValue1, value);
    }

    @Test
    public void testGetAtFirstIndexHavingMultipleValues() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        Integer insertValue1 = 10;
        Integer insertValue2 = 20;
        Integer insertValue3= 30;
        Integer insertValue4 = 40;
        Integer insertValue5 = 90;
        list.insert(insertValue1);
        list.insert(insertValue2);
        list.insert(insertValue3);
        list.insert(insertValue4);
        list.insert(insertValue5);
        Integer value = list.get(4);
        Assert.assertEquals(insertValue2, value);
        value = list.get(5);
        Assert.assertEquals(insertValue1, value);
    }

    @Test
    public void testGetAtFirstIndexHavingMultipleValuesAndDuplicates() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        Integer insertValue1 = 80;
        Integer insertValue2 = 20;
        Integer insertValue3= 10;
        Integer insertValue4 = 30;
        Integer insertValue5 = 10;
        list.insert(insertValue1);
        list.insert(insertValue2);
        list.insert(insertValue3);
        list.insert(insertValue4);
        list.insert(insertValue5);
        Integer value = list.get(3);
        Assert.assertEquals(insertValue3, value);
    }
}
