//this is a very good question of prefix and suffix
class Solution {
    public int longestAlternating(int[] nums) {
        int n = nums.length;
        int pref1[] = new int[n];
        int pref2[] = new int[n];
        int suf1[] = new int[n];
        int suf2[] = new int[n];

        for(int i = 0; i < n; i++){
            pref1[i] = pref2[i] = suf1[i] = suf2[i] = 1;
        }

        //now we find the prefix and suffix
        int ans = 1;
        for(int i = 1; i < n; i++){
            if(nums[i] > nums[i - 1]){
                pref1[i] = pref2[i - 1] + 1;
                ans = Math.max(ans, pref1[i]);
            }
            if(nums[i] < nums[i - 1]){
                pref2[i] = pref1[i - 1] + 1;
                ans = Math.max(ans, pref2[i]);
            }
        }

        for(int i = n - 2; i >= 0; i--){
            if(nums[i] > nums[i + 1]){
                suf1[i] = suf2[i + 1] + 1;
                ans = Math.max(ans, suf1[i]);
            }
            if(nums[i] < nums[i + 1]){
                suf2[i] = suf1[i + 1] + 1;
                ans = Math.max(ans, suf2[i]);
            }
        }

        //now try to delete one element
        for(int i = 1; i<n-1; i++){
            if(nums[i - 1] > nums[i + 1]){
                ans = Math.max(ans, pref1[i - 1] + suf2[i + 1]);
            }
            if(nums[i - 1] < nums[i + 1]){
                ans = Math.max(ans, pref2[i - 1] + suf1[i + 1]);
            }
        }

        return ans;
    }
}