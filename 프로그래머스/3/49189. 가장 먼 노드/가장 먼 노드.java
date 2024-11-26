import java.util.*;

class Solution {
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    boolean[] visited;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        for (int i = 0; i <= n; ++i) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] v : edge) {
            graph.get(v[0]).add(v[1]);
            graph.get(v[1]).add(v[0]);
        }
        
        visited = new boolean[n + 1];
        
        answer = bfs();
        
        return answer;
    }
    
    public int bfs() {
        Queue<int[]> que = new LinkedList<>();
        int answer = 0;
        
        que.add(new int[] {1, 0});
        visited[1] = true;
        int maxDist = 0;
        
        while (!que.isEmpty()) {
            int[] arr = que.poll();
            int v = arr[0];
            int dist = arr[1];
            
            if (maxDist == dist) {
                answer++;
            } else if (maxDist < dist) {
                maxDist = dist;
                answer = 1;
            }
            
            ArrayList<Integer> adj = graph.get(v);
            
            for (int i = 0; i < adj.size(); ++i) {
                int w = adj.get(i);
                if (!visited[w]) {
                    que.add(new int[] {w, dist + 1});
                    visited[w] = true;
                }
            }
        }
        
        return answer;
    }
}














