class Solution-300 {
	// 最长递增子序列
    public int lengthOfLIS(int[] nums) {
        int m = nums.length;
        if(m == 0) return 0;
        int ret = 1;
        int[] dp = new int[m];
        dp[0] = 1;
        for(int i = 1; i < m; ++i) {
            dp[i] = 1;
            for(int j = 0; j < i; ++j) {
                if(nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }
}
