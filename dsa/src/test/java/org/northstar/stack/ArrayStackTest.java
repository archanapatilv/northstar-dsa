package org.northstar.stack;

import org.junit.Assert;
import org.junit.Test;

public class ArrayStackTest {
    @Test
    public void testStackPushOneItem() throws Exception {
        Stack<Integer> stack = new ArrayStack<>();
        Integer integer = Integer.valueOf(10);
        stack.push(integer);
        Assert.assertEquals(integer, stack.top());
    }

    @Test
    public void testStackPushMultipleItems() throws Exception {
        Stack<Integer> stack = new ArrayStack<>();
        Integer integer10 = Integer.valueOf(10);
        Integer integer20 = Integer.valueOf(20);
        stack.push(integer10);
        stack.push(integer20);
        Assert.assertEquals(integer20, stack.top());
    }

    @Test (expected = Exception.class)
    public void testStackPushMultipleItemsToMax() throws Exception {
        Stack<Integer> stack = new ArrayStack<>();
        stack.push(Integer.valueOf(10));
        stack.push(Integer.valueOf(20));
        stack.push(Integer.valueOf(10));
        stack.push(Integer.valueOf(20));
        stack.push(Integer.valueOf(10));
        stack.push(Integer.valueOf(20));
        stack.push(Integer.valueOf(10));
        stack.push(Integer.valueOf(20));
        stack.push(Integer.valueOf(10));
        stack.push(Integer.valueOf(20));
        stack.push(Integer.valueOf(10));
    }

    @Test
    public void testStackPopWithOneItem() throws Exception {
        Stack<Integer> stack = new ArrayStack<>();
        Integer integer10 = Integer.valueOf(10);
        stack.push(integer10);
        Assert.assertEquals(integer10, stack.pop());
        Assert.assertTrue(stack.isEmpty());
    }

    @Test
    public void testStackPopMultipleItems() throws Exception {
        Stack<Integer> stack = new ArrayStack<>();
        Integer integer10 = Integer.valueOf(10);
        Integer integer20 = Integer.valueOf(20);
        stack.push(integer10);
        stack.push(integer20);
        Assert.assertEquals(integer20, stack.pop());
        Assert.assertFalse(stack.isEmpty());
        Assert.assertEquals(integer10, stack.pop());
        Assert.assertTrue(stack.isEmpty());
    }

    @Test
    public void testStackTopOneItem() throws Exception {
        Stack<Integer> stack = new ArrayStack<>();
        Integer integer10 = Integer.valueOf(10);
        stack.push(integer10);
        Assert.assertEquals(integer10, stack.top());
    }

    @Test
    public void testStackTopMultipleItem() throws Exception{
        Stack<Integer> stack = new ArrayStack<>();
        Integer integer10 = Integer.valueOf(10);
        Integer integer20 = Integer.valueOf(20);
        stack.push(integer10);
        Assert.assertEquals(integer10, stack.top());
        stack.push(integer20);
        Assert.assertEquals(integer20, stack.top());
        stack.push(integer10);
        Assert.assertEquals(integer10, stack.top());
        stack.pop();
        Assert.assertEquals(integer20, stack.top());
        stack.pop();
        Assert.assertEquals(integer10, stack.top());
    }

    @Test (expected = Exception.class)
    public void testStackPopWithNoItems() throws Exception {
        Stack<Integer> stack = new ArrayStack<>();
        Assert.assertEquals(null, stack.pop());
    }

    @Test
    public void testStackEmpty() {
        Stack<Integer> stack = new ArrayStack<>();
        Assert.assertTrue(stack.isEmpty());
    }

    @Test
    public void testStackEmptyWhenStackHasItems() throws Exception {
        Stack<Integer> stack = new ArrayStack<>();
        stack.push(Integer.valueOf(10));
        Assert.assertFalse(stack.isEmpty());
    }
}
