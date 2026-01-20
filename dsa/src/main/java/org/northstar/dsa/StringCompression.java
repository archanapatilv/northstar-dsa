package org.northstar.dsa;

public class StringCompression {
    static public int compress(char[] chars) {
        if(null == chars || 0 == chars.length) {
            return 0;
        }
        int len = chars.length;
        if(1 == len) {
            return len;
        }
        int count = 1;
        int availableIndex = 1;
        int index = 1;
        while(index < len ) {
            if(chars[index-1] == chars[index]) {
                count++;
                availableIndex = (availableIndex == 1) ? 1 : availableIndex;
            } else {
                if(count > 1) {
                    for(char c: Integer.toString(count).toCharArray()) {
                        chars[availableIndex++] = c;
                    }
                }
                chars[availableIndex++] = chars[index];
                count = 1;
            }
            index++;
        }
        if(count > 1) {
            for(char c: Integer.toString(count).toCharArray()) {
                chars[availableIndex++] = c;
            }
        }
        return availableIndex;
    }

    public static void main(String[] args) {

//        "a","a","a","b","b","a","a"
        char[] c = new char[]{'a', 'a', 'a', 'b', 'b', 'a', 'a'};
        int avlen = compress(c);
        System.out.print(avlen + " --> ");
        for(int i = 0; i < avlen; i++ ) {
            System.out.print(c[i] + " ");
        }

        System.out.println();
        c = new char[]{'a', 'b', 'c'};
         avlen = compress(c);
        System.out.print(avlen + " --> ");
        for(int i = 0; i < avlen; i++ ) {
            System.out.print(c[i] + " ");
        }

        System.out.println();
        c = new char[]{'a', 'a', 'b', 'b', 'b', 'c', 'c', 'c'};
        avlen = compress(c);
        System.out.print(avlen + " --> ");
        for(int i = 0; i < avlen; i++ ) {
            System.out.print(c[i] + " ");
        }

        System.out.println();
        c = new char[]{'a', 'b', 'b', 'b', 'b'};
        avlen = compress(c);
        System.out.print(avlen + " --> ");
        for(int i = 0; i < avlen; i++ ) {
            System.out.print(c[i] + " ");
        }

        System.out.println();
        c = new char[]{'a', 'b', 'b', 'c'};
        avlen = compress(c);
        System.out.print(avlen + " --> ");
        for(int i = 0; i < avlen; i++ ) {
            System.out.print(c[i] + " ");
        }
        System.out.println();
        c = new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        avlen = compress(c);
        System.out.print(avlen + " --> ");
        for(int i = 0; i < avlen; i++ ) {
            System.out.print(c[i] + " ");
        }
    }
}
