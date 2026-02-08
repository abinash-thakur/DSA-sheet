/*
leetcode - 239
time complexity O(n)
space complexity O(1)
*/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int ln = n - k + 1;

        int i = 0;
        int j = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        int res[] = new int[ln];

        while(j < n){
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[j]){
                dq.pollLast();
            }
            dq.addLast(j);

            while((j - i + 1) > k){
                if(dq.peekFirst() == i){
                    dq.pollFirst();
                }
                i++;
            }

            if((j - i + 1) == k){
                res[i] = nums[dq.peekFirst()];
            }
            j++;
        }

        return res;
    }
}