package org.northstar.dsa;

public class RemoveStarsFromAString {
    static public String removeStars(String s) {
        if(null == s || s.isBlank()) {
            return s;
        }
        int len = s.length();
        char[] c = new char[len];
        int j = 0;
        for(int i = 0 ; i < len; i++) {
            char p = s.charAt(i);
            if(p != '*') {
                c[j++] = p;
            } else {
                j--;
            }
        }
        return String.valueOf(c, 0, j);
    }

    public static void main(String[] args) {
        System.out.println(removeStars("leet**cod*e"));
    }
}
