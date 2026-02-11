/*
very important
leetcode - 3721
timecomplexity - O(nlogn)
*/
class Solution {
    private int segMin[];
    private int segMax[];
    private int lazy[];
    private void propagate(int i, int l, int r){
        if(lazy[i] != 0){
            segMin[i] += lazy[i];
            segMax[i] += lazy[i];

            if(l != r){
                lazy[2 * i + 1] += lazy[i];
                lazy[2 * i + 2] += lazy[i];
            }
            lazy[i] = 0;
        }
    }
    private void update(int start, int end, int i, int l, int r, int val){
        propagate(i, l, r);

        //if the query is not lie in my range
        if(end < l || start > r){
            return;
        }
        if(l >= start && r <= end){
            lazy[i] += val;
            propagate(i, l, r);
            return;
        }
        int mid = l + (r - l) / 2;
        update(start, end, 2 * i + 1, l, mid, val);
        update(start, end, 2 * i + 2, mid + 1, r, val);

        segMin[i] = Math.min(segMin[2 * i + 1], segMin[2 * i + 2]);
        segMax[i] = Math.max(segMax[2 * i + 1], segMax[2 * i + 2]);
    }
    private int findLeftMostZero(int i, int l, int r){
        propagate(i, l, r);
        if(segMax[i] < 0 || segMin[i] > 0){
            return -1;
        }
        if(l == r){
            return l;
        }
        int mid = l + (r - l) / 2;
        int left = findLeftMostZero(2 * i + 1, l, mid);
        return (left != -1) ? left : findLeftMostZero(2 * i + 2, mid + 1, r);
    }
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        segMin = new int[4 * n];
        segMax = new int[4 * n];
        lazy = new int[4 * n];

        Map<Integer, Integer> mp = new HashMap<>();
        int ans = 0;

        for(int i = 0; i < n; i++){
            int val = (nums[i] % 2 == 0) ? 1 : -1;

            int prev = -1;
            if(mp.containsKey(nums[i])){
                prev = mp.get(nums[i]);
            }

            if(prev != -1){
                update(0, prev, 0, 0, n - 1, -val);
            }

            update(0, i, 0, 0, n - 1, val);

            int j = findLeftMostZero(0, 0, n - 1);
            if(j != -1){
                ans = Math.max(ans, i - j + 1);
            }

            mp.put(nums[i], i);
        }
        return ans;
    }
}