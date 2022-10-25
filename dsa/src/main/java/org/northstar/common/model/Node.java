package org.northstar.common.model;

public class Node<T> {
    private T value;
    private Node nextNode;

    private Node prevNode;

    public Node(T value) {
        this.value = value;
    }

    public Node getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(Node prevNode) {
        this.prevNode = prevNode;
    }

    Node(T value, Node nextNode) {
        this.value = value;
        this.nextNode  = nextNode;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
