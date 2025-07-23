//leetcode 1717
//this question is do using 2 ways by using stack as well as two pointes
//by using the stack implementation time complexity is O(2n) -> O(n)
//space complexity is O(n) for using stack

class Solution {
    public int findPoints(String s, String match ,int point, Stack<Character> st, int n){
        int score = 0;
        
        for(int i = 0; i < n; i++){
            char curr = s.charAt(i);
            if(st.isEmpty()){
                st.push(curr);
                continue;
            }
            char ch = st.peek();
            if(ch == match.charAt(0) && curr == match.charAt(1)){
                score += point;
                st.pop();
            }
            else{
                st.push(curr);
            }
        }
        return score;
    }
    public int maximumGain(String s, int x, int y) {
        Stack<Character> st = new Stack<>();
        String first = x > y ? "ab" : "ba";
        int fpoint = x > y ? x : y;
        int spoint = x < y ? x : y;
        int n = s.length();
        int tScore = 0;

        //this is the first pass
        tScore = findPoints(s, first,fpoint, st, n);

        //I have to segrigate all remaining string from the stack
        StringBuilder remain = new StringBuilder();
        n = 0;
        while(!st.isEmpty()){
            remain.append(st.pop());
            n++;
        }

        //this is the second pass
        tScore += findPoints(remain.toString(), first,spoint, st, n);

        return tScore;
    }
}