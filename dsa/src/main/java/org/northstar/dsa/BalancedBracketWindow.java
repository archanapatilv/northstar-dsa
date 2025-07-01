package org.northstar.dsa;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedBracketWindow {

    public static boolean isValid(String s) {
        Map<Character, Character> braceRelation = new HashMap<>();
//        braceRelation.put('(', ')');
        braceRelation.put(')', '(');
//        braceRelation.put('[', ']');
        braceRelation.put(']', '[');
//        braceRelation.put('{', '}');
        braceRelation.put('}', '{');

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            Character c = Character.valueOf(s.charAt(i));
            switch(c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                case ']':
                case '}':
                    if(stack.isEmpty() ||
                            stack.peek() != braceRelation.get(c)) {
                        return false;
                    } else {
                        stack.pop();
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("() : is " + isValid("()"));
        System.out.println("] : is " + isValid("]"));
    }
}
