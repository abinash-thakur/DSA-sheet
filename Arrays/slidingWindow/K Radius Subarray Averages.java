/*
leetcode - 2090
timecomplexity - O(n)
*/
class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        long ps[] = new long[n];
        int res[] = new int[n];

        Arrays.fill(res, -1);

        ps[0] = (long)nums[0];
        for(int i = 1; i < n; i++){
            ps[i] = ps[i - 1] + nums[i];
        }

        for(int i = k; i <= n - k - 1; i++){
            int l = i - k;
            int r = i + k;

            if(i == k){
                res[i] = (int)(ps[r] / (r - l + 1));
            }
            else{
                res[i] = (int)((ps[r] - ps[l - 1]) / (r - l + 1));
            }
        }

        return res;
    }
}