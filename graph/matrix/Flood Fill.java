//leetCode 733
//time complexity O(X * 4) where X = number of nodes (because we traverse x connected node to color them)

class Solution {
    public void dfs(int[][] image, int track[][], int n, int m, int color, int i, int j, int coordinate[][], int startNum){
        track[i][j] = 1;
        image[i][j] = color;
        for(int k = 0; k < 4; k++){
            int row = i + coordinate[k][0];
            int col = j + coordinate[k][1];

            if(row >= 0 && row < n && col >= 0 && col < m && image[row][col] == startNum && track[row][col] == 0){
                dfs(image, track, n, m, color, row, col, coordinate, startNum);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int startNum = image[sr][sc];
        int track[][] = new int[n][m];
        int coordinate[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        dfs(image, track, n, m, color, sr, sc, coordinate, startNum);
        return image;
    }
}