//leetcode 1717
//this question is do using 2 ways by using stack as well as two pointes
//by using the two pointer implementation time complexity is O(2n) -> O(n)
//but there is no space required in this

class Solution {
    public String findPoints(String s, String match){
        char ch[] = s.toCharArray();
        int n = ch.length;
        int i = 0;
        int j = 0;


        while(j < n){
            ch[i] = ch[j];
            i++;
            if(i >= 2){
                if(match.charAt(0) == ch[i - 2] && match.charAt(1) == ch[i - 1]){
                    i = i - 2;
                }
            }
            j++;
        }

        StringBuilder str = new StringBuilder();
        j = 0;
        while(j < i){
            str.append(ch[j]);
            j++;
        }
        return str.toString();
    }
    public int maximumGain(String s, int x, int y) {
        String first = x > y ? "ab" : "ba";
        String second = x > y ? "ba" : "ab";
        int n = s.length();
        int tScore = 0;

        //this is the first pass
        String firstRemain = findPoints(s, first);
        int firstRemainLen = firstRemain.length();
        int firstRemove = n - firstRemainLen;
        tScore += ((firstRemove / 2) * Math.max(x, y));

        //this is the second pass
        String secondRemain = findPoints(firstRemain, second);
        int secondRemove = firstRemainLen - secondRemain.length();
        tScore += ((secondRemove / 2) * Math.min(x, y));

        return tScore;
    }
}