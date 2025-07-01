package org.northstar.dsa;

public class KnapSack {

    int[][] memo;
    //np hard
    private  int findMaxProfit(int[] weights, int[] profits, int capacity) {
        memo = new int[weights.length + 1][capacity + 1];
        return findMaxProfitInternal(weights, profits, capacity, 0, 0);
    }

    private  int findMaxProfitInternal(int[] weights, int[] profits, int capacity, int index, int currentWeight) {

        if(index >= weights.length) return 0;
        if(currentWeight + weights[index] > capacity) {
            if(memo[index][currentWeight] == 0) {
                // dont include as it exceeds the capacity.
                memo[index][currentWeight] = findMaxProfitInternal(weights, profits, capacity, index+1, currentWeight);
            }
            // dont include as it exceeds the capacity.
            return memo[index][currentWeight];
        }
        //either include or not include
        // include means, include this weight, increase the profit and reduce the capacity
        if(memo[index+1][currentWeight+weights[index]] == 0) {
            memo[index+1][currentWeight+weights[index]] = profits[index] + findMaxProfitInternal(weights, profits, capacity, index+1, currentWeight+weights[index]);
        }
        if(memo[index+1][currentWeight] == 0) {
            memo[index+1][currentWeight] = findMaxProfitInternal(weights, profits, capacity, index+1, currentWeight);
        }
        return Math.max(memo[index+1][currentWeight+weights[index]],memo[index+1][currentWeight]);

    }

    public static void main(String[] args) {
        KnapSack knapSack = new KnapSack();
        int[] weights = {4, 5, 1};
        int[] profits = {1, 2, 3};
        int capacity = 5;
        System.out.println(knapSack.findMaxProfit(weights, profits, capacity));
    }
}
