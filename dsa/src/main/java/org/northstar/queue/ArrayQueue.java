package org.northstar.queue;

public class ArrayQueue<T> implements Queue<T>{
    private int size = 3;
    private Object[] queue = new Object[size];
    private int front = -1;
    private int rear = -1;

    @Override
    public void enqueue(T value) throws Exception {
        if (isFullQueue()) {
            throw new Exception("Queue Full");
        }
        if (front == -1) {
            front++;
            rear++;
        } else {
            rear = (rear + 1) % size;
        }
        queue[rear] = value;
    }

    private boolean isFullQueue() {
        return (1 + rear) % size == front;
    }

    @Override
    public T dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue Empty");
        }
        T value = (T)queue[front];
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % size;
        }
        return value;
    }

    @Override
    public boolean isEmpty() {
        return front == -1;
    }

    @Override
    public T seek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue Empty");
        }
        return (T)queue[front];
    }

    @Override
    public String printQueue() {
        if (isEmpty()) {
            return "";
        }
        StringBuilder printedQueue = new StringBuilder();
        int i = front;
        int j = rear;
        while (i != j) {
            printedQueue.append(" ").append(queue[i]);
            i = (i + 1) % size;
        }
        printedQueue.append(" ").append(queue[i]);
        System.out.println(printedQueue);
        return printedQueue.toString();
    }
}
