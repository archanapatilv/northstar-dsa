package org.northstar.dsa;

public class AddTwoInteger {
    private static int addNumbers(int n1, int n2) {
        int base = 10;
        int sum = 0;
        int i = 1;
        int carry = 0;
        while(n1 != 0 || n2 != 0 || carry != 0) {
            int digit1 = n1%base;//last digit
            int digit2 = n2%base;
            n1 = n1/base; //first two digit
            n2 = n2/base;
            int temp = digit1 * i + digit2 * i;
            sum = sum + temp;
            carry = temp/10;
            i = i*base;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(addNumbers(100, 1333));
        System.out.println(addNumbers(99, 99));
        System.out.println(addNumbers(9, 99));
    }
}
