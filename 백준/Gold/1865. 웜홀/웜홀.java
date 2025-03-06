import java.io.*;
import java.util.*;

public class Main {
    
    static class Edge {
        int from;
        int to;
        int time;
        
        Edge(int from, int to, int time) {
            this.from = from;
            this.to = to;
            this.time = time;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        
        int TC = Integer.parseInt(token.nextToken());
        
        while (TC-- > 0) {
            token = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(token.nextToken());
            int M = Integer.parseInt(token.nextToken());
            int W = Integer.parseInt(token.nextToken());

            ArrayList<Edge> graph = new ArrayList<>();
            
            for (int i = 0; i < M; ++i) {
                token = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(token.nextToken());
                int E = Integer.parseInt(token.nextToken());
                int T = Integer.parseInt(token.nextToken());
                graph.add(new Edge(S, E, T));
                graph.add(new Edge(E, S, T));
            }
            
            for (int i = 0; i < W; ++i) {
                token = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(token.nextToken());
                int E = Integer.parseInt(token.nextToken());
                int T = Integer.parseInt(token.nextToken());
                graph.add(new Edge(S, E, -T));
            }
            
            if (hasNegativeCycle(N, graph)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
    
    private static boolean hasNegativeCycle(int N, ArrayList<Edge> graph) {
        int[] dist = new int[N + 1];
        
        for (int i = 0; i <= N; ++i) {
            boolean update = false;
            
            for (Edge edge : graph) {
                if (dist[edge.to] > dist[edge.from] + edge.time) {
                    dist[edge.to] = dist[edge.from] + edge.time;
                    update = true;
                    
                    if (i == N) {
                        return true;
                    }
                }
            }
            if (!update) {
                break;
            }
        }
        
        return false;
    }
}
