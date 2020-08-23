class Solution-416 {
    public boolean canPartition(int[] nums) {
        // 分割等和子集
        int sum = 0;
        for(int n: nums) sum += n;
        if(sum % 2 != 0) return false;
        int m = sum / 2, n = nums.length;
        boolean[][] dp = new boolean[m+1][n+1];
        for(int i = 0; i < m + 1; ++i) dp[i][0] = false;
        for(int i = 0; i < n + 1; ++i) dp[0][i] = true;

        for(int i = 1; i < m + 1; ++i) {
            for(int j = 1; j < n + 1; ++j) {
                if(i - nums[j-1] >= 0) {
                    dp[i][j] = dp[i-nums[j-1]][j-1] || dp[i][j-1];
                }
                else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }
}
