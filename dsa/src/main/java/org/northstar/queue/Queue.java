package org.northstar.queue;

public interface Queue<T> {
    void enqueue(T value) throws Exception;
    T dequeue() throws Exception;
    boolean isEmpty();
    T seek() throws Exception;
    String printQueue();
}
