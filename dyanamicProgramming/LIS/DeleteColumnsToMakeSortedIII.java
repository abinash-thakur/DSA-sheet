//timecomplexity of the code is O(n^2)
// and space complexity is O(n) for using the dp array
//qn 960 - very good problem practice it
class Solution {
    public int minDeletionSize(String[] strs) {
        int row = strs.length;
        int col = strs[0].length();
        int lis = 1;
        int dp[] = new int[col];

        Arrays.fill(dp, 1);

        for(int i = 0; i<col; i++){
            for(int j = 0; j<i; j++){
                boolean isTrue = true;
                for(int k = 0; k<row; k++){
                    if(strs[k].charAt(j) > strs[k].charAt(i)){
                        isTrue = false;
                        break;
                    }
                }
                if(isTrue){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    lis = Math.max(lis, dp[i]);
                }
            }
        }

        return col - lis;
    }
}