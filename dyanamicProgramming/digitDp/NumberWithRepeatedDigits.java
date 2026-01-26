/*
Given an integer n, return the number of positive integers in the range [1, n] that have at least one repeated digit.

 

Example 1:

Input: n = 20
Output: 1
Explanation: The only positive number (<= 20) with at least 1 repeated digit is 11.
Example 2:

Input: n = 100
Output: 10
Explanation: The positive numbers (<= 100) with atleast 1 repeated digit are 11, 22, 33, 44, 55, 66, 77, 88, 99, and 100.
Example 3:

Input: n = 1000
Output: 262
 

Constraints:

1 <= n <= 109
*/
class Solution {
    private int find(String str, int idx, int n, int mask, int tight, int zero, int cnt, int dp[][][][][]){
        if(idx == n){
            if(cnt >= 1)
                return 1;
            return 0;
        }
        if(dp[idx][cnt][mask][zero][tight] != -1){
            return dp[idx][cnt][mask][zero][tight];
        }

        int limit = (tight == 1) ? str.charAt(idx) - '0' : 9;
        int ans = 0;
        for(int i = 0; i <= limit; i++){
            int currZero = (zero == 1 && i == 0) ? 1 : 0;
            int currMask = mask;
            int currCount = cnt;
            if(currZero != 1){
                if((mask & (1 << i)) > 0){
                    currCount++;
                }
                currMask = mask | (1 << i);
            }
            int currTight = ((tight == 1) && (i == str.charAt(idx) - '0')) ? 1 : 0;

            ans += find(str, idx + 1, n, currMask, currTight, currZero, currCount, dp);
        }
        return dp[idx][cnt][mask][zero][tight] = ans;
    }
    public int numDupDigitsAtMostN(int n) {
        String str = Integer.toString(n);
        int dp[][][][][] = new int[11][11][1024][2][2];

        for(int dps[][][][] : dp){
            for(int arrss[][][] : dps){
                for(int arrs[][] : arrss){
                    for(int arr[] : arrs){
                        Arrays.fill(arr, -1);
                    }
                }
            }
        }

        return find(str, 0, str.length(), 0, 1, 1, 0, dp);
    }
}