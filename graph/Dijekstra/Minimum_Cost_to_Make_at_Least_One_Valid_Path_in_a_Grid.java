/*
qn - 1368
time complexity O(V + E) because we are using the dijekstra algorithm
*/

class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int cost[][] = new int[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[2], b[2]));

        for(int costs[] : cost){
            Arrays.fill(costs, Integer.MAX_VALUE);
        }

        pq.offer(new int[]{0,0,0});
        cost[0][0] = 0;
        int ans = Integer.MAX_VALUE;

        while(!pq.isEmpty()){
            int parent[] = pq.poll();
            int i = parent[0];
            int j = parent[1];
            int ccost = parent[2];
            int val = grid[i][j];


            int rcost = (val == 1) ? ccost : ccost + 1;
            int lcost = (val == 2) ? ccost : ccost + 1;
            int dcost = (val == 3) ? ccost : ccost + 1;
            int ucost = (val == 4) ? ccost : ccost + 1;

            if(j + 1 < n && cost[i][j + 1] > rcost){
                pq.offer(new int[]{i, j + 1, rcost});
                cost[i][j + 1] = rcost;
            }
            if(j - 1 >= 0 && cost[i][j - 1] > lcost){
                pq.offer(new int[]{i, j - 1, lcost});
                cost[i][j - 1] = lcost;
            }
            if(i + 1 < m && cost[i + 1][j] > dcost){
                pq.offer(new int[]{i + 1, j, dcost});
                cost[i + 1][j] = dcost;
            }
            if(i - 1 >= 0 && cost[i - 1][j] > ucost){
                pq.offer(new int[]{i - 1, j, ucost});
                cost[i - 1][j] = ucost;
            }
        }
        return cost[m - 1][n - 1];
    }
}