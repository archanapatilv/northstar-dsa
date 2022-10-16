package org.northstar.linkedlist;

public class Node<T> {
    private T value;
    private Node nextNode;

    Node(T value) {
        this.value = value;
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
