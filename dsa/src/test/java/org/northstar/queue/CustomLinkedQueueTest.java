package org.northstar.queue;

import org.junit.Assert;
import org.junit.Test;

public class CustomLinkedQueueTest {

    @Test
    public void testEnqueue() throws Exception {
        Queue<Integer> queue = new CustomLinkedQueue<>();
        queue.enqueue(10);
        Assert.assertEquals(Integer.valueOf(10), queue.seek());
        Assert.assertFalse(queue.isEmpty());
        Assert.assertEquals(Integer.valueOf(10), queue.dequeue());
        Assert.assertTrue(queue.isEmpty());
    }

    @Test
    public void testEnqueue1() throws Exception {
        Queue<Integer> queue = new CustomLinkedQueue<>();
        queue.enqueue(10);
        Assert.assertEquals(Integer.valueOf(10), queue.seek());
        queue.enqueue(20);
        Assert.assertEquals(Integer.valueOf(10), queue.seek());
        queue.enqueue(23);
        Assert.assertEquals(Integer.valueOf(10), queue.seek());
        Assert.assertFalse(queue.isEmpty());
    }

    @Test
    public void testEnqueue2() throws Exception {
        Queue<Integer> queue = new CustomLinkedQueue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        Assert.assertFalse(queue.isEmpty());
    }

    @Test(expected = Exception.class)
    public void testEnqueue3() throws Exception {
        Queue<Integer> queue = new CustomLinkedQueue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
    }

    @Test(expected = Exception.class)
    public void testEnqueue4() throws Exception {
        Queue<Integer> queue = new CustomLinkedQueue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        Assert.assertEquals(Integer.valueOf(10), queue.dequeue());
        queue.enqueue(40);
    }

    @Test
    public void testDequeue() throws Exception {
        Queue<Integer> queue = new CustomLinkedQueue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        Assert.assertEquals(Integer.valueOf(10), queue.dequeue());
        Assert.assertEquals(Integer.valueOf(20), queue.dequeue());
        Assert.assertEquals(Integer.valueOf(30), queue.dequeue());
        Assert.assertTrue(queue.isEmpty());
    }

    @Test
    public void testDequeue1() throws Exception {
        Queue<Integer> queue = new CustomLinkedQueue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        Assert.assertEquals(Integer.valueOf(10), queue.dequeue());
        Assert.assertEquals(Integer.valueOf(20), queue.dequeue());
        Assert.assertEquals(Integer.valueOf(30), queue.dequeue());
        Assert.assertTrue(queue.isEmpty());
        queue.enqueue(40);
        queue.enqueue(50);
        Assert.assertEquals(Integer.valueOf(40), queue.seek());
        Assert.assertEquals(Integer.valueOf(40), queue.dequeue());
    }

    @Test
    public void testDequeue2() throws Exception {
        Queue<Integer> queue = new CustomLinkedQueue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        Assert.assertEquals(" 10 20 30", queue.printQueue());
        Assert.assertEquals(Integer.valueOf(10), queue.dequeue());
        Assert.assertEquals(" 20 30", queue.printQueue());
        Assert.assertEquals(Integer.valueOf(20), queue.dequeue());
        Assert.assertEquals(" 30", queue.printQueue());
        Assert.assertEquals(Integer.valueOf(30), queue.dequeue());

        Assert.assertTrue(queue.isEmpty());
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);
        Assert.assertEquals(" 40 50 60", queue.printQueue());
        Assert.assertEquals(Integer.valueOf(40), queue.seek());
        Assert.assertEquals(" 40 50 60", queue.printQueue());
        Assert.assertEquals(Integer.valueOf(40), queue.dequeue());
        Assert.assertEquals(" 50 60", queue.printQueue());
    }

    @Test(expected = Exception.class)
    public void testDequeue3() throws Exception {
        Queue<Integer> queue = new CustomLinkedQueue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
    }

    @Test
    public void testIteration() throws Exception {
        Queue<Integer> queue = new CustomLinkedQueue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(40);
        queue.enqueue(50);
        Assert.assertEquals(" 30 40 50", queue.printQueue());
    }

    @Test
    public void testIteration1() throws Exception {
        Queue<Integer> queue = new CustomLinkedQueue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(40);
        queue.enqueue(50);
        Assert.assertEquals(" 30 40 50", queue.printQueue());
        queue.dequeue();
        queue.dequeue();
        Assert.assertEquals(" 50", queue.printQueue());
    }
}
