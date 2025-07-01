package org.northstar.dsa;

import org.apache.commons.lang3.tuple.Pair;

import java.util.LinkedList;

class MinStack {

    LinkedList<Pair<Integer, Integer>> stack;
    public MinStack() {
        stack = new LinkedList<>();
    }

    public void push(int val) {
        if(stack.isEmpty()) {
            stack.addFirst(Pair.of(val,val));
        } else {
            stack.addFirst(Pair.of(val, Math.min(val, stack.getFirst().getRight())));
        }

    }

    public void pop() {
        stack.removeFirst().getLeft();
    }

    public int top() {
        return stack.getFirst().getLeft();
    }

    public int getMin() {
        return stack.getFirst().getRight();
    }
}

class MinStackOptimised {

    LinkedList<Integer> stack;
    Integer minValue = Integer.MAX_VALUE;
    public MinStackOptimised() {
        stack = new LinkedList<>();
    }

    public void push(int actualValue) {
        if(actualValue > minValue) {
            stack.addFirst(actualValue);
        } else {
            Integer modifiedValue = 2 * actualValue - minValue;
            minValue = actualValue;
            stack.addFirst(modifiedValue);
        }

    }

    public Integer pop() {
        Integer val = stack.removeFirst();
        if (val > minValue) {
            return val;
        } else {
            int actualValue = minValue;
            minValue =  2 * minValue - val;
           return actualValue;
        }
    }

    public int top() {
        Integer val = stack.getFirst();
        if (val > minValue) {
            return val;
        } else {
            int actualValue = minValue;
            minValue =  2 * minValue - val;
            return actualValue;
        }
    }

    public int getMin() {
        return minValue;
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
