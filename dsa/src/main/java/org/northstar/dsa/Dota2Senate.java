package org.northstar.dsa;

import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate {
    static public String predictPartyVictory(String senate) {
        Queue<Integer> rQueue = new LinkedList<>();
        Queue<Integer> dQueue = new LinkedList<>();
        int len = senate.length();
        for(int i = 0; i < len; i++) {
            char c = senate.charAt(i);
            if(c == 'R') {
                rQueue.offer(i);
            } else {
                dQueue.offer(i);
            }
        }
        while(!rQueue.isEmpty() && !dQueue.isEmpty()) {
            int r = rQueue.peek();
            int d = dQueue.peek();
            if(r < d) {
                rQueue.offer(r+len);
            } else {
                dQueue.offer(d+len);
            }
            rQueue.poll();
            dQueue.poll();
        }

        return dQueue.isEmpty() ? "Radiant" : "Dire";
    }

    public static void main(String[] args) {
        System.out.println(predictPartyVictory("DRRDRDRDRDDRDRDR"));
    }
}
