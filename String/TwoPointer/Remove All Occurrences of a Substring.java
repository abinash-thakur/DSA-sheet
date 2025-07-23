//leetcode 1910
//time complexity O(p) * O(n)
// O(p) for traversing the part for every i >= 2
// O(n) for traversing complete string
// this can be solve using stack also

class Solution {
    public String removeOccurrences(String s, String part) {
        char schar[] = s.toCharArray();
        char pchar[] = part.toCharArray();
        int slen = schar.length;
        int plen = pchar.length;
        int i = 0, j = 0;

        while(j < slen){
            schar[i] = schar[j];
            i++;
            if(i >= plen){
                boolean isMatch = true;
                for(int k = 0; k < plen; k++){
                    if(schar[(i - (plen - k))] != pchar[k]){
                        isMatch = false;
                        break;
                    }
                }
                if(isMatch){
                    i = i - plen;
                }
            }
            j++;
        }
        j = 0;
        StringBuilder sb = new StringBuilder();
        while(j < i){
            sb.append(schar[j]);
            j++;
        }
        return sb.toString();
    }
}