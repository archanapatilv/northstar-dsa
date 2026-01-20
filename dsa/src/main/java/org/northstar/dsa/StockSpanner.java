package org.northstar.dsa;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Stack;

public class StockSpanner {
    Stack<Pair<Integer,Integer>> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        Pair p = Pair.of(price, 1);
        if(stack.isEmpty()) {
            stack.push(p);
        } else {
            while(!stack.isEmpty() && stack.peek().getLeft() < price) {
                p.setValue((int)p.getValue() + stack.pop().getRight());
            }
            stack.push(p);
        }
        return (int) p.getRight();
    }
}
