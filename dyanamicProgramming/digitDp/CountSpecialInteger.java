/*
We call a positive integer special if all of its digits are distinct.

Given a positive integer n, return the number of special integers that belong to the interval [1, n].

 

Example 1:

Input: n = 20
Output: 19
Explanation: All the integers from 1 to 20, except 11, are special. Thus, there are 19 special integers.
Example 2:

Input: n = 5
Output: 5
Explanation: All the integers from 1 to 5 are special.
Example 3:

Input: n = 135
Output: 110
Explanation: There are 110 integers from 1 to 135 that are special.
Some of the integers that are not special are: 22, 114, and 131.
 

Constraints:

1 <= n <= 2 * 109
*/

class Solution {
    private int find(String str, int idx, int n, int tight, int mask, int zero, int dp[][][][]){
        if(idx == n){
            return 1;
        }
        if(dp[idx][mask][tight][zero] != -1){
            return dp[idx][mask][tight][zero];
        }

        int limit = (tight == 1) ? str.charAt(idx) - '0' : 9;
        int ans = 0;
        for(int i = 0; i <=limit; i++){
            int currZero = (zero == 1 && i == 0) ? 1 : 0;
            int currMask = mask;

            if(currZero == 0){
                if((mask & (1 << i)) != 0){
                    continue;
                }
                currMask |= (1 << i);
            }

            int currTight = (tight == 1 && str.charAt(idx) - '0' == i) ? 1 : 0;
            ans += find(str, idx + 1, n, currTight, currMask, currZero, dp);
        }
        return dp[idx][mask][tight][zero] = ans;
    }
    public int countSpecialNumbers(int n) {
        String str = Integer.toString(n);
        
        int dp[][][][] = new int[20][1024][2][2];

        for(int dps[][][] : dp){
            for(int arrs[][] : dps){
                for(int arr[] : arrs){
                    Arrays.fill(arr, -1);
                }
            }
        }

        return find(str, 0, str.length(), 1, 0, 1, dp) - 1;
    }
}