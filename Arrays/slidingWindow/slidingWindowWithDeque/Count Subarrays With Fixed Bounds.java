/*
leetcode - 2444
timecomplexity - O(n)
but the current logic is very tricky
*/

class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        int minidx = -1;
        int maxidx = -1;
        int cidx = -1;

        long ans = 0L;

        for(int i = 0; i < n; i++){
            if(nums[i] < minK || nums[i] > maxK){
                cidx = i;
            }

            minidx = (nums[i] == minK) ? i : minidx;
            maxidx = (nums[i] == maxK) ? i : maxidx;

            int currMin = Math.min(minidx, maxidx);
            int temp = currMin - cidx;
            ans += (temp >= 0) ? (long)temp : 0L; 
        }
        return ans;
    }
}