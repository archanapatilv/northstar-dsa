package org.northstar.dsa;
import java.util.*;

public class LetterCombinationOfAPhoneNumber {
    public static List<String> letterCombinations(String digits) {
        Map<Character, List<Character>> map = new HashMap<>();
        List<Character> l2 = new ArrayList<>(); l2.add('a');l2.add('b');l2.add('c');
        map.put('2', l2);
        List<Character> l3 = new ArrayList<>(); l3.add('d');l3.add('e');l3.add('f');
        map.put('3', l3);
        List<Character> l4 = new ArrayList<>(); l4.add('g');l4.add('h');l4.add('i');
        map.put('4', l4);
        List<Character> l5 = new ArrayList<>(); l5.add('j');l5.add('k');l5.add('l');
        map.put('5', l5);
        List<Character> l6 = new ArrayList<>(); l6.add('m');l6.add('n');l6.add('o');
        map.put('6', l6);
        List<Character> l7 = new ArrayList<>(); l7.add('p');l7.add('q');l7.add('r');l7.add('s');
        map.put('7', l7);
        List<Character> l8 = new ArrayList<>(); l8.add('t');l8.add('u');l8.add('v');
        map.put('8', l8);
        List<Character> l9 = new ArrayList<>();l9.add('w');l9.add('x');l9.add('y');l9.add('z');
        map.put('9', l9);

        List<String> result = new ArrayList<>();

        if(null == digits || digits.isEmpty()) {
            return result;
        }

        backtrack(map, result, digits, 0, "");
        return result;

    }

    private static void backtrack(Map<Character, List<Character>> map, List<String> result, String digits, int currentDigitIndex , String combination) {
        if(digits.length() == combination.length()) {
            result.add(combination);
            return;
        }
        List<Character> characters = map.get(digits.charAt(currentDigitIndex));
        if(null != characters) {
            for(Character c1: characters) {
                backtrack(map, result, digits, currentDigitIndex+1, combination+c1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
