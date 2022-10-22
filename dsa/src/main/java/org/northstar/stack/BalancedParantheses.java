package org.northstar.stack;

//() {} []
//Expression ab, [ab]c
public class BalancedParantheses {
    private final char leftSquare = '[';
    private final char rightSquare = ']';
    private final char leftCurve = '(';
    private final char rightCurve = ')';
    private final char leftFlower = '{';
    private final char rightFlower = '}';

    public boolean isBalancedExpression(String expression) throws Exception {
        if (null == expression) {
            return false;
        }
        Stack<Character> stack = new ArrayStack<>();
        char[] arr = expression.toCharArray();
        for (char c: arr) {
            switch (c) {
                case leftCurve:
                case leftSquare:
                case leftFlower: {
                    stack.push(c);
                    break;
                }
                case rightCurve: {
                    if (stack.pop() != leftCurve) {
                        return false;
                    }
                    break;
                }
                case rightFlower: {
                    if (stack.pop() != leftFlower) {
                        return false;
                    }
                    break;
                }
                case rightSquare: {
                    if (stack.pop() != leftSquare) {
                        return false;
                    }
                    break;
                }
            }

        }
        return stack.isEmpty();
    }
}
