/*
leetcode - 1838
timecomplexity - O(n log n)
this can be done using two way using binary search but it take more time but it will accepted
but it will solve using sliding window technique also
*/

//using bs
class Solution {
    private int bs(int[] nums, int ps[], int l, int r, int i, int n, int ops){
        int maxLen = 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            int len = (i - mid + 1);
            int targetVal = len * nums[i];
            int currSum = (i == n - 1) ? ps[mid] : ps[mid] - ps[i + 1];
            int opsNeed = targetVal - currSum;

            if(opsNeed <= ops){
                maxLen = len;
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return maxLen;
    }
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int ps[] = new int[n];
        
        ps[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i--){
            ps[i] = ps[i + 1] + nums[i];
        }
        int ans = 1;
        for(int i = n - 1; i >= 1; i--){
            int currAns = bs(nums, ps, 0, i, i, n, k);
            ans = Math.max(ans, currAns);
        }

        return ans;
    }
}

//using the sliding window
// timecomplexity O(n long n)

class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        long ps[] = new long[n];
        
        ps[0] = (long)nums[0];
        for(int i = 1; i < n; i++){
            ps[i] = ps[i - 1] + (long)nums[i];
        }
        int ans = 1;
        int i = 0;
        int j = 0;

        while(j < n){
            int len = j - i + 1;
            long target = (long)nums[j] * len;
            long currSum = (i == 0) ? ps[j] : ps[j] - ps[i - 1];
            long opsNeed = target - currSum;

            if(opsNeed <= k){
                ans = Math.max(ans, len);
            }
            else{
                i++;
            }
            j++;
        }
        return ans;
    }
}