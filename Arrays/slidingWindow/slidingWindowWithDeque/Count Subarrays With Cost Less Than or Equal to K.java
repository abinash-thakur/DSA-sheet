/*
leetcode - 3835
timecomplexity - O(n)
*/
class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        Deque<Integer> maxd = new ArrayDeque<>();
        Deque<Integer> mind = new ArrayDeque<>();

        long ans = 0L;
        int l = 0;

        for(int r = 0; r < n; r++){
            while(!maxd.isEmpty() && nums[maxd.peekLast()] <= nums[r]){
                maxd.pollLast();
            }
            maxd.addLast(r);

            while(!mind.isEmpty() && nums[mind.peekLast()] >= nums[r]){
                mind.pollLast();
            }
            mind.addLast(r);

            while((long)(nums[maxd.peekFirst()] - nums[mind.peekFirst()]) * (r - l + 1) > k){
                if(maxd.peekFirst() == l) maxd.pollFirst();
                if(mind.peekFirst() == l) mind.pollFirst();
                l++;
            }
            ans += (long)(r - l + 1);
        }

        return ans;
    }
}