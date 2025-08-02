//leetcode 2561
//time complexity O(n) for traversing and O(nLogN) for sorting so total O(nLogN)
//space complexity O(n) for storing the frequency we used the hashMap.

class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        int n = basket1.length;
        Map<Integer, Integer> mp = new HashMap<>();
        int minVal = Integer.MAX_VALUE;

        //maintain the frequency
        for(int i = 0; i < n; i++){
            minVal = Math.min(minVal, Math.min(basket1[i], basket2[i]));
            mp.put(basket1[i], mp.getOrDefault(basket1[i], 0) + 1);
            mp.put(basket2[i], mp.getOrDefault(basket2[i], 0) - 1);
        }

        //now add those element who has to be distributed
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            int key = entry.getKey();
            int val = Math.abs(entry.getValue());

            if(val % 2 == 1){
                return -1;
            }
            int i = val / 2;
            while(i > 0){
                list.add(key);
                i--;
            }
        }

        if(list.size() == 0){
            return 0;
        }

        //Now sort the list
        Collections.sort(list);

        //Now find the res
        int halfSize = list.size() / 2;
        long res = 0;
        for(int i = 0; i < halfSize; i++){
            res += Math.min(list.get(i), 2 * minVal);
        }
        return res;
    }
}