//leetcode 898
//time complexity O(n * 32) (O(n) for traverse complete array and O(32) for traverse previous unique element in set and that are not more than 32)

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
