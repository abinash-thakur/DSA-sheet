/*
233. Number of Digit One
Solved
Hard
Topics
premium lock icon
Companies
Hint
Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

 

Example 1:

Input: n = 13
Output: 6
Example 2:

Input: n = 0
Output: 0
 

Constraints:

0 <= n <= 109
*/

class Solution {
    private int solve(String str, int tight, int idx, int n, int count, int dp[][][]){
        if(idx == n){
            return count;
        }
        if(dp[idx][tight][count] != -1){
            return dp[idx][tight][count];
        }

        int limit = (tight == 1) ? str.charAt(idx) - '0' : 9;
        int ans = 0;
        for(int i = 0; i <= limit; i++){
            int currTight = ((tight == 1) && (i == str.charAt(idx) - '0')) ? 1 : 0;
            ans += solve(str, currTight, idx + 1, n, count + ((i == 1) ? 1 : 0), dp);
        }
        return dp[idx][tight][count] = ans;
    }
    public int countDigitOne(int n) {
        String str = Integer.toString(n);
        int len = str.length();
        int dp[][][] = new int[len][2][11];
        for(int dps[][] : dp){
            for(int arr[] : dps){
                Arrays.fill(arr, -1);
            }
        }
        return solve(str, 1, 0, len, 0, dp);
    }
}