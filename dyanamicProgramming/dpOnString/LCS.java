//this is the tabulation and it take the timecomplexity O(n*m)
//recursion with memoization
class Solution {
    private int lcs(String s1, String s2, int i, int j, int dp[][]){
        if(i < 0 || j < 0){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = 1 + lcs(s1, s2, i - 1, j - 1, dp);
        }
        return dp[i][j] = Math.max(lcs(s1, s2, i - 1, j, dp), lcs(s1, s2, i, j - 1, dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int dp[][] = new int[n1][n2];
        for(int arr[] : dp){
            Arrays.fill(arr, -1);
        }
        return lcs(text1, text2, n1 - 1, n2 - 1, dp);
    }
}

//tabulation (top down format)
//this is the tabulation and it take the timecomplexity O(n*m)
//it take the spcace complexity on O(n * m)
class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n + 1][m + 1];
        //first we have to write the base cases
        //and the case -1 then 0 so it is not possible so we can shift one index and now start comparison from n to 0 and m to 0
        for(int i = 0; i<=n; i++){
            dp[i][0] = 0;
        }
        for(int j = 0; j<=m; j++){
            dp[0][j] = 0;
        }

        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=m; j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
}