//gfg Undirected Graph Cycle
//time complexity O(N) + 2E + ON
//space complexity O(N) for recursion stack space, O(N) for node, so total O(2n).


class Solution {
    public boolean dfs(List<List<Integer>> adj, int[] visited, int source, int parent){
        for(int curr : adj.get(source)){
            if(visited[curr] == 0){
                visited[curr] = 1;
                if(dfs(adj, visited, curr, source)){
                    return true;
                }
            }
            else if(curr != parent){
                return true;
            }
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        int isVisited[] = new int[V];
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        for(int i = 0; i < V; i++){
            if(isVisited[i] == 0){
                isVisited[i] = 1;
                if(dfs(adj, isVisited, i, -1)) return true;
            }
        }
        
        return false;
    }
}