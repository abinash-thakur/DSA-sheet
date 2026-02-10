/*
leetcode - 2271
timecomplexity - O(nlogn)
*/

class Solution {
    private int find(int[][] tiles, int target, int n){
        int l = 0;
        int r = n - 1;

        while(l <= r){
            int mid = l + (r - l) / 2;
            if(tiles[mid][1] <= target){
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }
        return (r < 0 || r >= n) ? -1 : r;
    }
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        int n = tiles.length;
        int ps[] = new int[n];

        Arrays.sort(tiles, (a,b) -> Integer.compare(a[0], b[0]));

        for(int i = 0; i < n; i++){
            if(i == 0){
                ps[i] = tiles[i][1] - tiles[i][0] + 1;
            }
            else{
                ps[i] = ps[i - 1] + (tiles[i][1] - tiles[i][0] + 1);
            }
        }

        int ans = 0;

        for(int i = 0; i < n; i++){
            int window = tiles[i][0] + carpetLen - 1;
            int coverIndex = find(tiles, window, n);

            int len = 0;
            if(coverIndex != -1){
                len = (i == 0) ? ps[coverIndex] : ps[coverIndex] - ps[i - 1];
            }
            if (coverIndex + 1 < n && tiles[coverIndex + 1][0] <= window) {
                len += window - tiles[coverIndex + 1][0] + 1;
            }
            ans = Math.max(ans, len);
        }

        return ans;
    }
}