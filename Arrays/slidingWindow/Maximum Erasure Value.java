//leetcode 1695
//time complexity O(n)
//space complexity O(n)

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Map<Integer, Boolean> mp = new HashMap<>();
        int n = nums.length;
        int i = 0, j = 0, sum = 0, maxSum = 0;

        while(j < n){
            if(!mp.containsKey(nums[j])){
                sum += nums[j];
                mp.put(nums[j], true);
            }
            else{
                while(nums[i] != nums[j]){
                    sum -= nums[i];
                    mp.remove(nums[i]);
                    i++;
                }
                i++;
            }
            maxSum = Math.max(maxSum, sum);
            j++;
        }
        return maxSum;
    }
}