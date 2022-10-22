package org.northstar.linkedlist;

import org.northstar.common.model.Node;

public class DoublyLinkedList<T> {
    private Node head;
    private int size;

    public DoublyLinkedList() {
        head = null;
        size = 0;
    }

    public void insert(T value) {
        Node node = new Node(value);
        if (null != head) {
            node.setNextNode(head);
            head.setPrevNode(node);
        }
        head = node;
        size++;
    }

    public void insert(T value, int position) {
        if(null == head || position < 1 || position > size + 1) {
            throw new IllegalArgumentException("List not initialized or Invalid operation");
        }
        if (position == 1) {
            insert(value);
        } else if (position == size + 1) {
            Node node = new Node(value);
            Node temp = head;
            while (null != temp.getNextNode()) {
                temp = temp.getNextNode();
            }
            temp.setNextNode(node);
            node.setPrevNode(temp);
            size++;
        } else {
            Node node = new Node(value);
            int count = 1;
            Node temp = head;
            while (count != position) {
                count++;
                temp = temp.getNextNode();
            }
            node.setNextNode(temp);
            node.setPrevNode(temp.getPrevNode());
            temp.setPrevNode(node);
            size++;
        }
    }

    public void delete(T value) {
        if (null == head) {
            throw new IllegalStateException("List not initialized");
        }
        if (size == 1 && head.getValue().equals(value)) {
            head = null;
            size--;
        } else if (head.getValue().equals(value)) {
            head = head.getNextNode();
            head.setPrevNode(null);
            size--;
        } else {
            Node temp = head.getNextNode();
            while (null != temp) {
                if(temp.getValue().equals(value)) {
                    temp.getPrevNode().setNextNode(temp.getNextNode());
                    if (null != temp.getNextNode()) {
                        temp.getNextNode().setPrevNode(temp.getPrevNode());
                    }
                    size--;
                    break;
                }
                temp = temp.getNextNode();
            }
        }
    }

    public boolean contains(T value) {
        if (null != head) {
            Node<T> tempNode = head;
            while (null != tempNode) {
                if (tempNode.getValue().equals(value)) {
                    return true;
                }
                tempNode = tempNode.getNextNode();
            }
        }
        return false;
    }

    public T get(int index) {
        if (null == head || index < 1 || index > size ) {
            throw new IllegalArgumentException("List not initialized or Invalid operation");
        }
        int count = 1;
        Node<T> currentNode = head;
        while (count != index) {
            currentNode = currentNode.getNextNode();
            count ++;
        }
        return currentNode.getValue();
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
