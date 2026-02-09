/*
leetcode - 1589
this problem is added in a line sweep list but this problem is solved using difference array technique(difference array technique is a part of lineSweep technique).

time complexity - 
for sorting - O(nlogn + nlogn) = O(2nlogn) = O(nlogn)
for traversing the array = O(2n) = O(n)
so overall - O(nlogn)

*/

class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int MOD = (int)(1e9 + 7);
        int n = nums.length;
        int track[] = new int[n];

        for(int request[] : requests){
            int start = request[0];
            int end = request[1];
            track[start]++;
            if(end + 1 < n){
                track[end + 1]--;
            }
        }

        //now we have to find the cumulative sum as we do in the dat
        for(int i = 1; i<n; i++){
            track[i] += track[i - 1];
        }

        Arrays.sort(track);
        Arrays.sort(nums);

        long sum = 0L;
        for(int i = 0; i < n; i++){
            sum = (sum + ((long)nums[i] * track[i]) % MOD) % MOD;
        }

        return (int)sum;
    }
}