package org.northstar.stack;

public interface Stack<T> {
    void push(T value) throws Exception;
    T pop() throws Exception;
    T top() throws Exception;
    boolean isEmpty();
}
