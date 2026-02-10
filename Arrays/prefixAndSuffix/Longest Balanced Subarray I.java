/*
leetcode - 3719
timecomplexity - O(n^2)
*/

class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;

        int ans = 0;
        for(int i = 1; i < n; i++){
            Set<Integer> set = new HashSet<>();  
            int odd = 0;
            int even = 0;          
            for(int j = i; j >= 0; j--){
                if(!set.contains(nums[j])){
                    set.add(nums[j]);
                    odd += (nums[j] % 2 != 0) ? 1 : 0;
                    even += (nums[j] % 2 == 0) ? 1 : 0;
                }

                if(odd == even){
                    ans = Math.max(ans, i - j + 1);
                }
            }
        }

        return ans;
    }
}