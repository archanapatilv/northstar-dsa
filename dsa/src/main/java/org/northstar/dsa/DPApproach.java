package org.northstar.dsa;

import java.util.HashMap;
import java.util.Map;

public class DPApproach {
    static Map<Integer, Integer> memo = new HashMap<>();

    // You start with required value
    //Top down approach
    static int fib(int n) {
        if(n <= 1) {
            return n;
        }
        if(memo.get(n) == null) {
            memo.put(n , fib(n-1) + fib(n-2));
        }
        return memo.get(n);
    }


    // you start with smaller value
    // bottom up approach

    static int fibonacci(int n) {
        if(n <= 1) {
            return n;
        }
        int[] dp = new int[n+1];
        //solve the base problem and have answers
        dp[0] = 0;
        dp[1] = 1;

        // build solution based on the base solution
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    //bottom up space optimised
    static int fibonacciOptimised(int n) {
        if(n <= 1) {
            return n;
        }

        //solve the base problem and have answers
        int prev0 = 0;
        int prev1 = 1;
        int current = 0;
        // build solution based on the base solution
        for(int i = 2; i <= n; i++) {
            current = prev1 + prev0;
            prev0 = prev1;
            prev1 = current;
        }
        return current;
    }
}
