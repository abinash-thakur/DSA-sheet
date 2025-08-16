//time complexity O(1) 
class Solution {
    public int minSensors(int n, int m, int k) {
        int size = 2 * k + 1;
        int row = (n / size) + (n % size == 0 ? 0 : 1);
        int col = (m / size) + (m % size == 0 ? 0 : 1);

        return row * col;
    }
}