//leetcode 898
//time complexity O(n * d) (O(n) for traverse complete array and O(d) for traverse previous unique element in set)

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