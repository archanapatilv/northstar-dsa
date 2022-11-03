package org.northstar.queue;

import org.northstar.common.model.Node;

public class CustomLinkedQueue<T> implements Queue<T> {

    private Node front = new Node(null);
    private Node rear = new Node(null);
    private int length = 0;
    private int size = 3;
    @Override
    public void enqueue(T value) throws Exception {
        if (length == size) {
            throw new Exception("Queue is Full.");
        }
        Node<T> node = new Node<T>(value);
        if (null == front.getNextNode()) {
            rear.setPrevNode(node);
            node.setNextNode(rear);
        } else {
            node.setNextNode(front.getNextNode());
            front.getNextNode().setPrevNode(node);
        }
        node.setPrevNode(front);
        front.setNextNode(node);
        length++;
    }

    @Override
    public T dequeue() throws Exception {
        if(isEmpty()) {
            throw new Exception("Queue is Empty");
        }
        T value = (T)rear.getPrevNode().getValue();
        if (front == rear.getPrevNode().getPrevNode()) {
            front.setNextNode(null);
            rear.setPrevNode(null);
        } else {
            rear.setPrevNode(rear.getPrevNode().getPrevNode());
        }
        length--;
        return value;
    }

    @Override
    public boolean isEmpty() {
        return null == front.getNextNode();
    }

    @Override
    public T seek() throws Exception {
        if(isEmpty()) {
            throw new Exception("Queue is Empty");
        }
        return (T)rear.getPrevNode().getValue();
    }

    @Override
    public String printQueue() {
        if (isEmpty()) {
            return "";
        }
        StringBuilder printedQueue = new StringBuilder();
        Node temp = rear.getPrevNode();
        while (temp != front) {
            printedQueue.append(" ").append(temp.getValue());
            temp = temp.getPrevNode();
        }
        System.out.println(printedQueue);
        return printedQueue.toString();
    }
}
