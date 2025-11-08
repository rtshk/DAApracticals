package exp8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int[] dijkstra(int v, int[][] edges, int src) {
        // code here
        
        ArrayList<ArrayList<int[]>> g = new ArrayList<>();
        
        for(int i=0;i<v;i++){
            g.add(new ArrayList<>());
        }
        
        for(int e[] : edges){
            g.get(e[0]).add(new int[] {e[1], e[2]});
            g.get(e[1]).add(new int[] {e[0], e[2]});
        }
        
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[1]-b[1]);
        int dist[] = new int[v];
        Arrays.fill(dist, (int)1e8);
        dist[src] = 0;
        
        q.add(new int[] {src, 0});
        
        while(!q.isEmpty()){
            int curr[] = q.remove();
            int node = curr[0];
            int w = curr[1];
            
            for(int e[] : g.get(node)){
                int dest = e[0];
                int wt = e[1];
                
                if(dist[node]+wt < dist[dest]){
                    dist[dest] = dist[node]+wt;
                    q.add(new int[] {dest, dist[dest]});
                }
            }
        }
        
        return dist;
    }
}