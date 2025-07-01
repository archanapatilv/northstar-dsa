package org.northstar.dsa;

public class StringToInteger {
    private static int      stringToInteger(String n) {
        int num = 0;
        boolean isNegative = n.startsWith("-");
        boolean isPositive = n.startsWith("+");
        int startIndex =  isNegative || isPositive ? 1: 0;
        for (int i = startIndex; i < n.length(); i++) {
            char a = n.charAt(i);
            if(a < '0' || a > '9') {
                throw new NumberFormatException("Invalid character found: " + a);
            }
            int digit = a - '0';
            num = num * 10 + digit;
        }
        return isNegative ? -num : num;
    }

    public static void main(String[] args) {
        System.out.println(stringToInteger("9999999"));
    }
}
