class Solution-376 {
    public int wiggleMaxLength(int[] nums) {
        int m = nums.length;
        if(m < 2) return m;
        int[] diff = new int[m-1];
        for(int i = 1; i < m; ++i) {
            diff[i-1] = nums[i] - nums[i-1];
        }
        int[] dp = new int[m-1];
        dp[0] = diff[0] == 0 ? 0 : 1;
        int ret = dp[0];
        for(int i = 1; i < m - 1; ++i) {
            dp[i] = diff[i] == 0 ? 0 : 1;
            for(int j = 0; j < i; ++j) {
                if(diff[j] * diff[i] < 0) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            ret = Math.max(dp[i], ret);
        }
        return ret + 1;
    }
}
