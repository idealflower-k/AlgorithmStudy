import java.io.*;
import java.util.*;

public class Main {
    
    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int dist;
        
        Edge(int from, int to, int dist) {
            this.from = from;
            this.to = to;
            this.dist = dist;
        }
        
        @Override
        public int compareTo(Edge o) {
            return this.dist - o.dist;
        }
    }
    
    static PriorityQueue<Edge> graph;
    static int[] parent;
    static int[] rank;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        
        int m = Integer.parseInt(token.nextToken());
        int n = Integer.parseInt(token.nextToken());
        
        while (m != 0 || n != 0) {
            graph = new PriorityQueue<>();
            int total = 0;
            for (int i = 0; i < n; ++i) {
                token = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(token.nextToken());
                int to = Integer.parseInt(token.nextToken());
                int dist = Integer.parseInt(token.nextToken());
                
                graph.offer(new Edge(from, to, dist));
                total += dist;
            }
            
            total -= getMST(m);
            System.out.println(total);
            token = new StringTokenizer(br.readLine());
            m = Integer.parseInt(token.nextToken());
            n = Integer.parseInt(token.nextToken());
        }
    }
    
    private static int getMST(int m) {
        int cost = 0;
        parent = new int[m];
        rank = new int[m];
        for (int i = 0; i < m; ++i) {
            parent[i] = i;
        }
        
        while (!graph.isEmpty()) {
            Edge edge = graph.poll();
            int from = edge.from;
            int to = edge.to;
            
            if (find(from) != find(to)) {
                union(from, to);
                cost += edge.dist;
            }
        }
        return cost;
    }
    
    private static int find(int a) {
        if (a == parent[a]) {
            return a;
        }
        
        return parent[a] = find(parent[a]);
    }
    
    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if (a == b) {
            return;
        }
        
        if (rank[a] < rank[b]) {
            parent[a] = b;
        } else {
            parent[b] = a;
            if (rank[a] == rank[b]) {
                rank[a]++;
            }
        }
    }
}
