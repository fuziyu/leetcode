class Solution-322 {
    // 零钱兑换
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int[] dp = new int[amount+1];
        Arrays.sort(coins);
        for(int i = 0; i < coins.length && coins[i] <= amount; ++i) {
            dp[coins[i]] = 1;
        }
        for(int i = 1; i < amount + 1; ++i) {
            dp[i] = dp[i] == 1 ? dp[i] : Integer.MAX_VALUE;
            for(int j = 0; j < coins.length && coins[j] <= i; ++j) {
                int k = i - coins[j];
                if(dp[k] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[k]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
