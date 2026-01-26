/*
Given a positive integer n, return the number of the integers in the range [0, n] whose binary representations do not contain consecutive ones.

 

Example 1:

Input: n = 5
Output: 5
Explanation:
Here are the non-negative integers <= 5 with their corresponding binary representations:
0 : 0
1 : 1
2 : 10
3 : 11
4 : 100
5 : 101
Among them, only integer 3 disobeys the rule (two consecutive ones) and the other 5 satisfy the rule. 
Example 2:

Input: n = 1
Output: 2
Example 3:

Input: n = 2
Output: 3
 

Constraints:

1 <= n <= 10^9
*/

class Solution {
    private int solve(String str, int idx, int n, int tight, int one, int dp[][][]){
        if(idx == n){
            return 1;
        }
        if(dp[idx][tight][one] != -1){
            return dp[idx][tight][one];
        }

        int limit = (tight == 1) ? str.charAt(idx) - '0' : 1;
        int ans = 0;
        for(int i = 0; i <= limit; i++){
            if(one == 1 && i == 1){
                continue;
            }
            int nextTight = (tight == 1 && str.charAt(idx) - '0' == i) ? 1 : 0;
            int nextOne = (i == 1) ? 1 : 0;
            ans += solve(str, idx + 1, n, nextTight, nextOne, dp);
        }
        return dp[idx][tight][one] = ans;
    }
    public int findIntegers(int n) {
        String str = Integer.toBinaryString(n);
        int dp[][][] = new int[33][2][2];
        for(int dps[][] : dp){
            for(int arr[] : dps){
                Arrays.fill(arr, -1);
            }
        }
        return solve(str, 0, str.length(), 1, 0, dp);
    }
}