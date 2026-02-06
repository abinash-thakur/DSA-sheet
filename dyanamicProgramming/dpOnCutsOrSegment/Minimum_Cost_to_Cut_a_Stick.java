/*
time complexity O(n) space complexity O(103 * 103) stack space O(n)
*/

class Solution {
    private int solve(int l, int r, int cuts[], int dp[][]){
        if(r - l < 2){
            return 0;
        }
        if(dp[l][r] != -1){
            return dp[l][r];
        }
        int ans = Integer.MAX_VALUE;
        for(int i = l + 1; i < r; i++){
            int cost = (cuts[r] - cuts[l]) + solve(l, i, cuts, dp) + solve(i, r, cuts, dp);
            ans = Math.min(ans, cost);
        }
        return dp[l][r] = ans;
    }
    public int minCost(int n, int[] cuts) {
        int ln = cuts.length;
        int arr[] = new int[ln + 2];

        arr[0] = 0;
        arr[ln + 1] = n;
        for(int i = 0; i < ln; i++){
            arr[i + 1] = cuts[i];
        }
        Arrays.sort(arr);

        int dp[][] = new int[103][103];
        for(int dps[] : dp){
            Arrays.fill(dps, -1);
        }

        return solve(0, ln + 1, arr, dp);
    }
}