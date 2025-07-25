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

//using constant space
//constraint given as the nums are from 0 to 100 so it take 101 size of array to check the frequency and for negative element i take a variable to store the largest negative number.
//space complexity O(100)

class Solution {
    public int maxSum(int[] nums) {
        boolean track[] = new boolean[101];
        int n = nums.length;
        int neg = Integer.MIN_VALUE;
        int sum = 0;

        for(int i = 0; i < n; i++){
            if(nums[i] > 0 && !track[nums[i]]){
                sum += nums[i];
                track[nums[i]] = true;
            }
            else{
                neg = Math.max(neg, nums[i]);
            }
        }
        return sum != 0 ? sum : neg;
    }
}