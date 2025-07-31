// Leetcode 898: Bitwise ORs of Subarrays
// Time Complexity: O(n * 32) = O(n)
// - For each element, we compute OR with at most 32 previous results (due to limited 32-bit values)
// - OR operation only sets bits (never unsets), so new combinations are limited
// - res tracks all unique ORs from all subarrays
// Space Complexity: O(n * 32) in worst case due to result set size

class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> prev = new HashSet<>();

        for(int num : arr){
            Set<Integer> temp = new HashSet<>();
            temp.add(num);
            for(int currOr : prev){
                temp.add(num | currOr);
            }
            res.addAll(temp);
            prev = temp;
        }
        return res.size();
    }
}
