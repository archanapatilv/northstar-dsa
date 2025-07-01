import java.util.Arrays;
import java.util.List;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (null == coins || coins.length == 0 || amount == 0) {
            return -1;
        }
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int currentAmount = 1; currentAmount <= amount ; currentAmount++) {
            for (int coinIndex = 0; coinIndex < coins.length; coinIndex++) {
                if(coins[coinIndex] <= currentAmount) {
                    dp[currentAmount] = Math.min(dp[currentAmount], dp[currentAmount - coins[coinIndex]] + 1);
                    }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }


    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(new int[]{1, 2, 5}, 11));
    }

}
