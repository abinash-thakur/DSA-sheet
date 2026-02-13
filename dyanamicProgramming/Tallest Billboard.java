/*
This is a very good problem try to revised
company - google
leetcode - 956
timecomplexity - O(n) and space complexity O(21)(10003)
*/
class Solution {
    private int solve(int i, int n, int rods[], int diff, int dp[][]){
        if(i == n){
            if(diff == 0){
                return 0;
            }
            return (Integer.MIN_VALUE / 2);
        }
        if(dp[i][diff + 5000] != -1){
            return dp[i][diff + 5000];
        }

        int notTake = solve(i + 1, n, rods, diff, dp);
        int takeRod1 = rods[i] + solve(i + 1, n, rods, diff + rods[i], dp);
        int takeRod2 = rods[i] + solve(i + 1, n, rods, diff - rods[i], dp);
        return dp[i][diff + 5000] = Math.max(notTake, Math.max(takeRod1, takeRod2));
    }
    public int tallestBillboard(int[] rods) {
        int n = rods.length;
        int dp[][] = new int[n][10002];

        for(int dps[] : dp){
            Arrays.fill(dps, -1);
        }
        return solve(0, n, rods, 0, dp) / 2;
    }
}