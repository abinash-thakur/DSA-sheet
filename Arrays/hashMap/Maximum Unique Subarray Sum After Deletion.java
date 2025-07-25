//leetcode 3487
//time complexity O(n)
//space complexity O(n) because we are using hashMap

class Solution {
    public int maxSum(int[] nums) {
        HashMap<Integer, Boolean> mp = new HashMap<>();
        int n = nums.length;
        int maxSum = nums[0];
        mp.put(nums[0], true);

        for(int i = 1; i < n; i++){
            if(!mp.containsKey(nums[i])){
                int currSum= maxSum + nums[i];
                maxSum = Math.max(maxSum, Math.max(currSum, nums[i]));
                mp.put(nums[i], true);
            }
        }
        return maxSum;
    }
}