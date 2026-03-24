// leetcode - 174
// timecomplexity O(m * n) and spacecomplexity also take O(m * n) and as well as we used the stack space of O(m * n)


// class Solution {
//     private int solve(int[][] dungeon, int m, int n, int i, int j, int dp[][]){
//         if(i == m - 1 && j == n - 1){
//             if(dungeon[i][j] < 0){
//                 return Math.abs(dungeon[i][j]) + 1;
//             }
//             return 1; 
//         }

//         if(dp[i][j] != -1){
//             return dp[i][j];
//         }

//         int right = Integer.MAX_VALUE;
//         int down = Integer.MAX_VALUE;

//         if(i + 1 < m){
//             down = solve(dungeon, m, n, i + 1, j, dp);
//         }
//         if(j + 1 < n){
//             right = solve(dungeon, m, n, i, j + 1, dp);
//         }

//         int minVal = Math.min(right, down);
//         int diff = minVal - dungeon[i][j];
        
//         return dp[i][j] = (diff <= 0) ? 1 : diff;
//     }
//     public int calculateMinimumHP(int[][] dungeon) {
//         int m = dungeon.length;
//         int n = dungeon[0].length;
//         int dp[][] = new int[201][201];

//         for(int dps[] : dp){
//             Arrays.fill(dps, -1);
//         }

//         return solve(dungeon, m, n, 0, 0, dp);
//     }
// }

//timecomplexity O(m * n)
//spacecomplexity O(m * n)
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int dp[][] = new int[m][n];

        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(i == m - 1 && j == n - 1){
                    if(dungeon[i][j] < 0){
                        dp[i][j] = Math.abs(dungeon[i][j]) + 1;
                    }
                    else{
                        dp[i][j] = 1;
                    }
                    continue;
                }

                int right = Integer.MAX_VALUE;
                int down = Integer.MAX_VALUE;

                if(i + 1 < m){
                    down = dp[i + 1][j];
                }
                if(j + 1 < n){
                    right = dp[i][j + 1];
                }

                int minVal = Math.min(right, down);
                int diff = minVal - dungeon[i][j];
        
                dp[i][j] = (diff <= 0) ? 1 : diff;
            }
        }

        return dp[0][0];
    }
}