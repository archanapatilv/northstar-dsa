public class CoinChangeII {
    public int change(int amount, int[] coins) {
        if(null == coins || 0 == coins.length) {
            return 0;
        }
        if(amount == 0) {
            return 1;
        }
        return _change(amount, coins, coins.length - 1);
    }

    private int _change(int amount, int[] coins, int index) {
        if (index == 0) {
            return (amount % coins[index] == 0) ? 1 : 0;
        }
        int dontTake = _change(amount, coins, index-1);
        int take = (coins[index] <= amount) ? _change(amount - coins[index], coins, index): 0;
        return take + dontTake;
    }

    public static void main(String[] args) {
        CoinChangeII c = new CoinChangeII();
        System.out.println(c.change(5, new int[]{1, 2, 5}));
    }
}
