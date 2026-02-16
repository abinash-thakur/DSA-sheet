/*
leetcode(hard) - 1575
timecomplexity - O(n);
space complexity - O(101 * 201)
*/
class Solution {
    private int MOD = (int)(1e9 + 7);
    private int solve(int start, int end, int[] loc, int n, int fuel, int dp[][]){
        if(fuel < 0){
            return 0;
        }

        if(dp[start][fuel] != -1){
            return dp[start][fuel];
        }

        int path = (start == end) ? 1 : 0;
        for(int i = 0; i < n; i++){
            if(i != start){
                int fuelConsume = Math.abs(loc[start] - loc[i]);
                path = (path + solve(i, end, loc, n, fuel - fuelConsume, dp)) % MOD;
            }
        }
        return dp[start][fuel] = path;
    }
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        int dp[][] = new int[101][201];
        for(int dps[] : dp){
            Arrays.fill(dps, -1);
        }
        return solve(start, finish, locations, n, fuel, dp);
    }
}