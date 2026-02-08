/*
leetcode - 3834
timecomplexity - O(n)
*/

class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        Stack<Long> st = new Stack<>();
        for(int e : nums){
            if(st.isEmpty()){
                st.push((long)e);
            }
            else{
                long ans = e;
                while(!st.isEmpty() && st.peek() == ans){
                    st.pop();
                    ans *= 2L;
                }
                st.push(ans);
            }
        }

        List<Long> res = new ArrayList<>();
        while(!st.isEmpty()){
            res.add(st.pop());
        }

        Collections.reverse(res);
        return res;
    }
}