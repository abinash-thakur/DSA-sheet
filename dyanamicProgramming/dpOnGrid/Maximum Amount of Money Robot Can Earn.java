//This is a very good edge case hadeling and take and skip problem in grid
//Time complexity O(m * n * k) but k = 2 so it becomes O(m * n)
//leetcode 3418

class Solution {
    private int solve(int i, int j, int k, int m, int n, int coins[][], int dp[][][]){
        if(i >= m || j >= n){
            return Integer.MIN_VALUE;
        }

        if(i == m - 1 && j == n - 1){
            if(k > 0){
                return Math.max(coins[i][j], 0);
            }
            return coins[i][j];
        }

        if(dp[i][j][k] != Integer.MIN_VALUE){
            return dp[i][j][k];
        }

        int right = solve(i + 1, j, k, m, n, coins, dp);
        int down = solve(i, j + 1, k, m, n, coins, dp);

        int bestTake = Math.max(right, down);

        int take = (bestTake == Integer.MIN_VALUE) ? Integer.MIN_VALUE : coins[i][j] + bestTake;
        int skip = Integer.MIN_VALUE;

        if(k != 0){
            skip = Math.max(solve(i + 1, j, k - 1, m, n, coins, dp), solve(i, j + 1, k - 1, m, n, coins, dp));
        }

        return dp[i][j][k] = Math.max(take, skip);
    }
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        int dp[][][] = new int[m][n][3];

        for(int dps[][] : dp){
            for(int row[] : dps){
                Arrays.fill(row, Integer.MIN_VALUE);
            }
        }

        return solve(0, 0, 2, m, n, coins, dp);
    }
}
