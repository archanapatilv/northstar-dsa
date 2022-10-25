package org.northstar.stack;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Character.isAlphabetic;
import static java.lang.Character.isDigit;

public class InfixToPostFix {

    private static Map<Character, Integer> operatorMap;
    static {
        operatorMap = new HashMap<>();
        operatorMap.put('(', 0);
        operatorMap.put(')', 0);
        operatorMap.put('+', 1);
        operatorMap.put('-', 1);
        operatorMap.put('*', 2);
        operatorMap.put('/', 2);
    }
    // op1 + op2 => op1op2+
    public static String infixToPostFix(String expression) throws Exception {
        Stack<Character> stack = new LinkedStack<>();
        StringBuilder postFixExpression = new StringBuilder();
        char[] exp = expression.toCharArray();

        for (char c: exp) {
            if(isAlphabetic(c)) {
                postFixExpression.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (stack.top() != '(') {
                    postFixExpression.append(stack.pop());
                }
                stack.pop();
            } else {
                if (!stack.isEmpty() && operatorMap.get(c) <= operatorMap.get(stack.top()) && stack.top() != '(') {
                    while (!stack.isEmpty()  && stack.top() != '(') {
                        postFixExpression.append(stack.pop());
                    }
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            postFixExpression.append(stack.pop());
        }
        return postFixExpression.toString();
    }
}
