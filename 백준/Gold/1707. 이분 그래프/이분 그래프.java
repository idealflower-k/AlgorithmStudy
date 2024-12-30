import java.io.*;
import java.util.*;

public class Main {
    
    public static List<Integer>[] graph;
    public static boolean[] visited;
    public static int[] grouped;
    public static boolean res;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int K = Integer.parseInt(token.nextToken());
        
        for (int i = 0; i < K; ++i) {
            token = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(token.nextToken());
            int E = Integer.parseInt(token.nextToken());
            
            graph = new ArrayList[V + 1];
            for (int j = 0; j <= V; ++j) {
                graph[j] = new ArrayList<>();
            }
            
            visited = new boolean[V + 1];
            grouped = new int[V + 1];
            res = true;
            
            for (int j = 0; j < E; ++j) {
                token = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(token.nextToken());
                int to = Integer.parseInt(token.nextToken());
                
                graph[from].add(to);
                graph[to].add(from);
            }
            
            for (int j = 1; j <= V; ++j) {
                if (!visited[j] && res) {
                    bfs(j);
                } else if (!res) {
                    break;
                }
            }
            
            if (res) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        
        System.out.print(sb.toString());
    }
    
    public static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visited[start] = true;
        
        while (!que.isEmpty()) {
            int node = que.poll();
            
            for (int nb : graph[node]) {
                if (visited[nb]) {
                    if (grouped[node] == grouped[nb]) {
                        res = false;
                        return;
                    }
                } else {
                    grouped[nb] = 1 - grouped[node];
                    visited[nb] = true;
                    que.add(nb);
                }
            }
        }
    }
}