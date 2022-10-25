package org.northstar.stack;

import org.northstar.common.model.Node;

public class LinkedStack<T> implements Stack<T>{
    private Node<T> head = null;

    public void push(T value) {
        Node<T> node = new Node(value);
        if (null != head) {
            node.setNextNode(head);
        }
        head = node;
    }
    public T pop() throws Exception {
        if (null != head) {
            T value = head.getValue();
            head = head.getNextNode();
            return value;
        }
        throw new Exception("Stack Empty");
    }

    public T top() throws Exception {
        if (null != head) {
            return head.getValue();
        }
        throw new Exception("Stack Empty");
    }

    public boolean isEmpty() {
        return head == null;
    }
}
