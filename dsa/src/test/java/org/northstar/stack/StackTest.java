package org.northstar.stack;

import org.junit.Assert;
import org.junit.Test;

public class StackTest {

    @Test
    public void testStackPushOneItem() {
        Stack<Integer> stack = new Stack<>();
        Integer integer = Integer.valueOf(10);
        stack.push(integer);
        Assert.assertEquals(integer, stack.top());
    }

    @Test
    public void testStackPushMultipleItems() {
        Stack<Integer> stack = new Stack<>();
        Integer integer10 = Integer.valueOf(10);
        Integer integer20 = Integer.valueOf(20);
        stack.push(integer10);
        stack.push(integer20);
        Assert.assertEquals(integer20, stack.top());
    }

    @Test
    public void testStackPopWithOneItem() {
        Stack<Integer> stack = new Stack<>();
        Integer integer10 = Integer.valueOf(10);
        stack.push(integer10);
        Assert.assertEquals(integer10, stack.pop());
        Assert.assertTrue(stack.isEmpty());
    }

    @Test
    public void testStackPopMultipleItems() {
        Stack<Integer> stack = new Stack<>();
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
    public void testStackTopOneItem() {
        Stack<Integer> stack = new Stack<>();
        Integer integer10 = Integer.valueOf(10);
        stack.push(integer10);
        Assert.assertEquals(integer10, stack.top());
    }

    @Test
    public void testStackTopMultipleItem() {
        Stack<Integer> stack = new Stack<>();
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
        stack.pop();
        Assert.assertEquals(null, stack.top());
    }

    @Test
    public void testStackPopWithNoItems() {
        Stack<Integer> stack = new Stack<>();
        Assert.assertEquals(null, stack.pop());
    }

    @Test
    public void testStackEmpty() {
        Stack<Integer> stack = new Stack<>();
        Assert.assertTrue(stack.isEmpty());
    }

    @Test
    public void testStackEmptyWhenStackHasItems() {
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.valueOf(10));
        Assert.assertFalse(stack.isEmpty());
    }
}
