package org.northstar.queue;

import org.northstar.common.model.Node;

public class LinkedQueue<T> implements Queue<T> {
    private Node front;
    private Node rear;
    private int size = 3;
    private int length = 0;
    @Override
    //insert at front
    public void enqueue(T value) throws Exception {
        if (isFull()) {
            throw new Exception("Queue is full");
        }
        Node node = new Node(value);
        if (null == front) {
            front = rear = node;
            node.setNextNode(node);
            node.setPrevNode(node);
        } else {
            //point current front to node
            node.setNextNode(front);
            node.setPrevNode(rear);
            front.setPrevNode(node);
            front = node;

            //point current tail end to node
            rear.setNextNode(node);;
        }
        length++;
    }

    private boolean isFull() {
        return length == size;
    }

    @Override
    public T dequeue() throws Exception {
        if(isEmpty()) {
            throw new Exception("Queue is Empty");
        }
        Node temp = rear;
        if (front == rear) {
            front = rear = null;
        } else {
            rear.getNextNode().setPrevNode(rear.getPrevNode());
            rear = rear.getPrevNode();
        }
        length--;
        return (T)temp.getValue();
    }

    @Override
    public boolean isEmpty() {
        return null == front;
    }

    @Override
    public T seek() throws Exception {
        if(isEmpty()) {
            throw new Exception("Queue is Empty");
        }
        return (T)rear.getValue();
    }

    @Override
    public String printQueue() {
        if (null == front) {
            return "";
        }
        StringBuilder printedQueue = new StringBuilder();
        Node temp = rear;
        while (temp != front) {
            printedQueue.append(" ").append(temp.getValue());
            temp = temp.getPrevNode();
        }
        printedQueue.append(" ").append(temp.getValue());
        System.out.println(printedQueue);
        return printedQueue.toString();
    }
}
