package org.northstar.stack;

import static java.lang.Character.isDigit;

public class InfixToPostFix {
    public static final char L_PARENTHESES = '(';
    public static final char R_PARENTHESES = ')';
    public static final char ADD = '+';
    public static final char SUB = '-';
    public static final char MULTIPLY = '*';
    public static final char DIVIDE = '/';

    private enum Operators {
        ADDITION (ADD, 1),
        SUBTRACTION (SUB, 1),
        MULTIPLICATION (MULTIPLY, 2),
        DIVISION (DIVIDE, 2),
        LEFT_PARENTHESES (L_PARENTHESES, 0);

        private char operator;
        private int weight;

        private Operators(char operator, int weight) {
            this.operator = operator;
            this.weight = weight;
        }
    }

    // op1 + op2 => op1op2+
    public static String infixToPostFix(String expression) throws Exception {
        Stack<Operators> stack = new LinkedStack<>();
        String postFixExpression = "";
        char[] exp = expression.toCharArray();
        for (char c: exp) {
            switch (c) {
                case L_PARENTHESES: {
                    stack.push(Operators.LEFT_PARENTHESES);
                }
                break;
                case R_PARENTHESES: {
                    while (stack.top() != Operators.LEFT_PARENTHESES) {
                        postFixExpression += stack.pop().operator;
                    }
                    stack.pop();
                }
                break;
                case ADD: {
                    // Remove from stack when the value score is lesser than or equal the one at the top of the stack
                    if (!stack.isEmpty() && Operators.ADDITION.weight <= stack.top().weight && stack.top().operator != L_PARENTHESES) {
                        while (!stack.isEmpty()  && stack.top().operator != L_PARENTHESES) {
                            postFixExpression += stack.pop().operator;
                        }
                    }
                    stack.push(Operators.ADDITION);
                }
                break;
                case SUB: {
                    // Remove from stack when the value score is lesser than or equal the one at the top of the stack
                    if (!stack.isEmpty() && Operators.SUBTRACTION.weight <= stack.top().weight  && stack.top().operator != L_PARENTHESES) {
                        while (!stack.isEmpty()  && stack.top().operator != L_PARENTHESES) {
                            postFixExpression += stack.pop().operator;
                        }
                    }
                    stack.push(Operators.SUBTRACTION);
                }
                break;
                case MULTIPLY: {
                    if (!stack.isEmpty() && Operators.MULTIPLICATION.weight <= stack.top().weight  && stack.top().operator != L_PARENTHESES) {
                        while (!stack.isEmpty() && stack.top().operator != L_PARENTHESES) {
                            postFixExpression += stack.pop().operator;
                        }
                    }
                    stack.push(Operators.MULTIPLICATION);
                }
                break;
                case DIVIDE: {
                    if (!stack.isEmpty() && Operators.DIVISION.weight <= stack.top().weight  && stack.top().operator != L_PARENTHESES) {
                        while (!stack.isEmpty() && stack.top().operator != L_PARENTHESES) {
                            postFixExpression += stack.pop().operator;
                        }
                    }
                    stack.push(Operators.DIVISION);
                }
                break;
                default: {
                    postFixExpression += c;
                }
            }
        }
        while (!stack.isEmpty()) {
            postFixExpression += stack.pop().operator;
        }
        return postFixExpression;
    }
}
