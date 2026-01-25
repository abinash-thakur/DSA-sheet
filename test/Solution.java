class Solution{

    public static void findArea(int n, int m, char pizza[][], int apple[][]){
        for(int j = m - 1; j >= 0; j--){
            int currSum = 0;
            for(int i = n - 1; i >= 0; i--){
                currSum += (pizza[i][j] == 'A') ? 1 : 0;
                int currTotal = (j + 1 < m) ? (apple[i][j + 1] + currSum) : currSum;
                apple[i][j] = currTotal;  
            }
        }
    }
    public static void main(String[] args){
        char pizza[][] = {{'A', '0', '0'}, {'A', 'A', 'A'}, {'0', '0', '0'}};
        int n = 3;
        int m = 3;
        int apple[][] = new int[3][3];

        findArea(n, m, pizza, apple);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(apple[i][j] + " ");
            }
            System.out.println();
        }
    }
}