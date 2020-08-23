class Solution-646 {
    public int findLongestChain(int[][] pairs) {
        // 最长数对链
        Arrays.sort(pairs, (a, b) -> {
            return a[1] - b[1];
        });
        int m = pairs.length;
        if(m == 0) return 0;
        int[] dp = new int[m];
        int max = 1;
        for(int i = 0; i < m; ++i) {
            dp[i] = 1;
            for(int j = 0; j < i; ++j) {
                if(pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
