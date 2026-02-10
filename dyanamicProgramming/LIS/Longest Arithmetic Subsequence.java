/*
This is a classic LIS problem
Timecomplexity - O(n^2)
Solve it using the bottomup lis
*/

class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][1002];

        if(n == 2){
            return 2;
        }

        int ans = 0;
        for(int i = 1 ; i < n; i++){
            for(int j = 0; j < i ; j++){
                int diff = nums[i] - nums[j] + 501;
                dp[i][diff] = (dp[j][diff] == 0) ? 2 : dp[j][diff] + 1;
                ans = Math.max(ans, dp[i][diff]);
            }
        }

        return ans;
    }
}