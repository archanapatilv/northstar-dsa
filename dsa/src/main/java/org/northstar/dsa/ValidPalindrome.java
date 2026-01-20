package org.northstar.dsa;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int left = 0; int right = s.length() - 1;
        while(left < right) {
            if(!Character.isAlphabetic(s.charAt(left))
                    && !Character.isDigit(s.charAt(left))) {
                left++;
                continue;
            } else if (!Character.isAlphabetic(s.charAt(right))
                    && !Character.isDigit(s.charAt(right))) {
                right--;
                continue;
            } else if(Character.toLowerCase((s.charAt(left))) != Character.toLowerCase((s.charAt(right)))){
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        vp.isPalindrome("0P");
    }
}
