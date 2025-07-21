//Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.

//You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.

// Example 1:

// Input: nums = [1,2,1,3,2,5]
// Output: [3,5]
// Explanation:  [5, 3] is also a valid answer.
// Example 2:

// Input: nums = [-1,0]
// Output: [-1,0]
// Example 3:

// Input: nums = [0,1]
// Output: [1,0]

class Solution {
    public int[] singleNumber(int[] nums) {
        long xor = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++)
        {
            xor = xor ^ nums[i];
        }
        int rightMostSetBit = (int)((xor & (xor - 1)) ^ xor);

        int setBucket = 0;
        int unsetBucket = 0;
        for(int i = 0; i<n; i++)
        {
            if((rightMostSetBit & nums[i]) != 0)
                setBucket = setBucket ^ nums[i];
            else
                unsetBucket = unsetBucket ^ nums[i];
        }
        int result[] = {setBucket, unsetBucket};
        return result;
    }
}