package org.northstar.stack;

public class ArrayStack<T> implements Stack<T> {
    private static final Integer SIZE = 10;
    private Object[] stack = new Object[SIZE];
    private int top = -1;
    @Override
    public void push(T value) throws Exception {
        if(top == SIZE) {
            throw new Exception("Stack Full");
        }
        stack[++top]= value;
    }
    @Override
    public T pop() throws Exception {
        if (top != -1) {
            return (T)stack[top--];
        } else {
            throw new Exception("Stack Empty");
        }
    }
    @Override
    public T top() throws Exception {
        if (top != -1) {
            return (T)stack[top];
        } else {
            throw new Exception("Stack Empty");
        }
    }
    @Override
    public boolean isEmpty() {
        return top == -1;
    }
}
