package org.northstar.linkedlist;

import org.northstar.common.model.Node;

public class LinkedList<T> {
    private Node head;
    private int size;

    LinkedList() {
        head = null;
        size = 0;
    }

    public void insert(T value) {
        Node<T> node = new Node<>(value);
        if (null != head) {
            Node<T> tempNode = head;
            node.setNextNode(tempNode);
        }
        head = node;
        size++;
    }

    public void insert(T value, int position) {
        if (position <= 0 || position > size + 1 || null == head && position > 0) {
            throw new IllegalArgumentException("Invalid Position");
        }
        Node<T> node = new Node<>(value);
        if (null == head && position == 1) {
            head = node;
            size++;
        } else if (position == 1) {
            node.setNextNode(head);
            head = node;
            size++;
        } else {
            int count = 1;
            Node<T> previousNode = null;
            Node<T> currentNode = head;
            while (count != position) {
                previousNode = currentNode;
                currentNode = currentNode.getNextNode();
                count ++;
            }
            previousNode.setNextNode(node);
            node.setNextNode(currentNode);
            size++;
        }
    }

    public void delete(T value) {
        if (null != head) {
            Node<T> previousNode = null;
            Node<T> tempNode = head;
            while (null != tempNode) {
                if (tempNode.getValue().equals(value)) {
                    break;
                }
                previousNode = tempNode;
                tempNode = tempNode.getNextNode();
            }
            if (null != tempNode) {
                if (null == previousNode) {
                    head = tempNode.getNextNode();
                } else {
                    previousNode.setNextNode(tempNode.getNextNode());
                }
                size--;
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
        if(null == head) {
            throw new IllegalStateException("List not initialized");
        }
        if (index <= 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid Index");
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

    public void reverseLinkedListIteratively() {
        if(null != head) {
            Node temp = head;
            Node prev = null;
            Node next = null;
            while(null != temp) {
                next = temp.getNextNode();
                temp.setNextNode(prev);
                prev = temp;
                temp = next;
            }
            head = prev;
        }
    }

    public void reverseLinkedList() {
       if (null != head) {
           Node temp = head;
           reverseInternally(temp).setNextNode(null);
       }
    }

    //1->2->3
    private Node reverseInternally(Node node) {
        if (null != node.getNextNode()) {
            reverseInternally(node.getNextNode()).setNextNode(node);
        } else {
            head = node;
        }
        return node;
    }

    /*public void printLinkedList() {
        Node temp = head;
        while (null != temp) {
            System.out.print(" " + temp.getValue());
            temp = temp.getNextNode();
        }
        System.out.println();
    }*/
}
