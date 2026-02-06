/*
qn - 3634 (classical sliding window problem)
for sorting O(nlogn)
for iterating array it take O(n)
*/

class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int i = 0;
        int j = 0;
        int ans = Integer.MAX_VALUE;

        while(j < n){
            int val = (int)Math.ceil(nums[j]/(double)k);
            if(val <= nums[i]){
                ans = Math.min(ans, n-(j - i + 1));
            }
            while(val > nums[i]){
                i++;
            }
            j++;
        }

        return ans;
    }
}
