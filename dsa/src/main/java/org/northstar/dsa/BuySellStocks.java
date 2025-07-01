package org.northstar.dsa;

public class BuySellStocks {

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int currentProfit = 0;
        int buy_price = 0;

        buy_price = prices[0];
        for (int i = 1; i < prices.length; i++) {
            //buy when lower
            if (prices[i] < buy_price) {
                buy_price = prices[i];
            } // sell when higher
            else {
                currentProfit = prices[i] - buy_price;
                maxProfit = Math.max(maxProfit, currentProfit);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices  = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit = " + maxProfit(prices));
        prices  = new int[]{7, 2, 4, 5, 1, 3};
        System.out.println("Max Profit = " + maxProfit(prices));
        prices  = new int[]{7, 2, 4, 5, 1, 3, 6, 4};
        System.out.println("Max Profit = " + maxProfit(prices));
        prices  = new int[]{7, 6, 5, 4, 3, 2};
        System.out.println("Max Profit = " + maxProfit(prices));
    }
}
