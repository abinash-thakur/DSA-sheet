//leetcode - 1888
//This is a very good problem of the circular string or array problem of sliding window
//timecomplexity - O(2 * n)
//spacecomplexity - O(1)

class Solution {
    public int minFlips(String s) {
        String str = s + s;
        int n = s.length();
        int i = 0;
        int f1 = 0;
        int f2 = 0;
        int minFlip = Integer.MAX_VALUE;
        
        for(int j = 0; j < 2*n; j++){
            if(j % 2 == 0){
                if(s.charAt(j % n) == '0'){
                    f2++;
                }
                else{
                    f1++;
                }
            }
            else{
                if(s.charAt(j % n) == '0'){
                    f1++;
                }
                else{
                    f2++;
                }
            }

            if(j - i == n){
                if(i % 2 == 0){
                    if(s.charAt(i % n) == '0'){
                        f2--;
                    }
                    else{
                        f1--;
                    }
                }
                else{
                    if(s.charAt(i % n) == '0'){
                        f1--;
                    }
                    else{
                        f2--;
                    }
                }
                i++;
            }

            if(j - i + 1 == n){
                minFlip = Math.min(minFlip, Math.min(f1, f2));
            }
        }

        return minFlip;
    }
}
