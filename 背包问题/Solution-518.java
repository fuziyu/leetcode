class Solution-518 {
    // 找零钱的硬币数组合
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount+1][coins.length+1];
        for(int i = 0; i < coins.length + 1; ++i) dp[0][i] = 1;
        for(int i = 1; i < amount + 1; ++i) {
            for(int j = 1; j < coins.length + 1; ++j) {
                dp[i][j] = dp[i][j-1];
                if(i - coins[j-1] >= 0) dp[i][j] += dp[i-coins[j-1]][j];
            }
        }
        return dp[amount][coins.length];
    }
}
