/*
time complexity O(log(E) * (V + E))

You are given two integers, n and threshold, as well as a directed weighted graph of n nodes numbered from 0 to n - 1. The graph is represented by a 2D integer array edges, where edges[i] = [Ai, Bi, Wi] indicates that there is an edge going from node Ai to node Bi with weight Wi.

You have to remove some edges from this graph (possibly none), so that it satisfies the following conditions:

Node 0 must be reachable from all other nodes.
The maximum edge weight in the resulting graph is minimized.
Each node has at most threshold outgoing edges.
Return the minimum possible value of the maximum edge weight after removing the necessary edges. If it is impossible for all conditions to be satisfied, return -1.

 

Example 1:

Input: n = 5, edges = [[1,0,1],[2,0,2],[3,0,1],[4,3,1],[2,1,1]], threshold = 2

Output: 1

Explanation:



Remove the edge 2 -> 0. The maximum weight among the remaining edges is 1.

Example 2:

Input: n = 5, edges = [[0,1,1],[0,2,2],[0,3,1],[0,4,1],[1,2,1],[1,4,1]], threshold = 1

Output: -1

Explanation: 

It is impossible to reach node 0 from node 2.

Example 3:

Input: n = 5, edges = [[1,2,1],[1,3,3],[1,4,5],[2,3,2],[3,4,2],[4,0,1]], threshold = 1

Output: 2

Explanation: 



Remove the edges 1 -> 3 and 1 -> 4. The maximum weight among the remaining edges is 2.

Example 4:

Input: n = 5, edges = [[1,2,1],[1,3,3],[1,4,5],[2,3,2],[4,0,1]], threshold = 1

Output: -1

 

Constraints:

2 <= n <= 105
1 <= threshold <= n - 1
1 <= edges.length <= min(105, n * (n - 1) / 2).
edges[i].length == 3
0 <= Ai, Bi < n
Ai != Bi
1 <= Wi <= 106
There may be multiple edges between a pair of nodes, but they must have unique weights.
*/

class Solution {
    private void dfs(List<List<List<Integer>>> adj, int k, int visited[], int u){
        for(List<Integer> child : adj.get(u)){
            int v = child.get(0);
            int w = child.get(1);
            if(w <= k && visited[v] == 0){
                visited[v] = 1;
                dfs(adj, k,visited, v);
            }
        }
    }
    private boolean isPossible(List<List<List<Integer>>> adj, int k, int n){
        int visited[] = new int[n];
        visited[0] = 1;
        dfs(adj, k, visited, 0);

        for(int e : visited){
            if(e == 0){
                return false;
            }
        }
        return true;
    }
    public int minMaxWeight(int n, int[][] edges, int threshold) {
        //first we have to create the adjacency list
        List<List<List<Integer>>> adj = new ArrayList<>();
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            List<Integer> list = new ArrayList<>();
            list.add(u);
            list.add(w);
            adj.get(v).add(list);

            low = Math.min(low, w);
            high = Math.max(high, w);
        }

        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isPossible(adj, mid, n)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return ans;
    }
}