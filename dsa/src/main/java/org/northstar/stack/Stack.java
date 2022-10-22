package org.northstar.stack;

import org.northstar.common.model.Node;

public class Stack<T> {
    private Node<T> head = null;

    public void push(T value) {
        Node<T> node = new Node(value);
        if (null != head) {
            node.setNextNode(head);
        }
        head = node;
    }

    public T pop() {
        if (null != head) {
            T value = head.getValue();
            head = head.getNextNode();
            return value;
        }
        return null;
    }

    public T top() {
        if (null != head) {
            return head.getValue();
        }
        return null;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
