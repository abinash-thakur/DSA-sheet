/*
leetcode - 1456
timecomplexity - O(n)
*/

class Solution {
    private boolean isVowel(char ch){
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') ? true : false;
    }
    public int maxVowels(String s, int k) {
        int ans = 0;
        int count = 0;
        int i = 0;
        int j = 0;
        int n = s.length();

        while(j < n){
            char ch = s.charAt(j);
            if(isVowel(ch)){
                count++;
            }
            while(j - i + 1 > k){
                if(isVowel(s.charAt(i))){
                    count--;
                }
                i++;
            }
            if(j - i + 1 == k){
                ans = Math.max(ans, count);
            }
            j++;
        }

        return ans;
    }
}