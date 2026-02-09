/*
leetcode - 2328
basically this problem is solve using the dfs but this problem also can solve using the matrix chain multiplication (dp)
timecomplexity - O(m * n)
spacecomplexity - O(m * n)  
*/

class Solution {
    private int MOD = (int)(1e9 + 7);
    private int solve(int i, int j, int m, int n, int directions[][], int grid[][], int dp[][]){
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int res = 1;
        for(int dir[] : directions){
            int curri = i + dir[0];
            int currj = j + dir[1];

            if(curri >=0 && curri < m && currj >= 0 && currj < n && grid[curri][currj] < grid[i][j]){
                res = (res + solve(curri, currj, m, n, directions, grid, dp)) % MOD;
            }
        }

        return dp[i][j] = res;
    }
    public int countPaths(int[][] grid) {
        int dir[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        int ans = 0;

        for(int dps[] : dp){
            Arrays.fill(dps, -1);
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                ans = (ans + solve(i, j, m, n, dir, grid, dp)) % MOD;
            }
        }
        return ans;
    }
}