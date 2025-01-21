import java.io.*;
import java.util.*;

public class Main {
    
    static class Node implements Comparable<Node> {
        int v;
        int dist;
        
        Node(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }
        
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.dist, o.dist);
        }
    }
    
    static List<Node>[] graph;
    static int[] dists;
    static int V;
    static int E;
    static int start;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        
        V = Integer.parseInt(token.nextToken());
        E = Integer.parseInt(token.nextToken());
        start = Integer.parseInt(br.readLine());
        
        graph = new ArrayList[V + 1];
        dists = new int[V + 1];
        
        for (int i = 0; i <= V; ++i) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < E; ++i) {
            token = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(token.nextToken());
            int to = Integer.parseInt(token.nextToken());
            int dist = Integer.parseInt(token.nextToken());
            
            graph[from].add(new Node(to, dist));
        }
        
        dijkstra();
        
        for (int i = 1; i <= V; ++i) {
            int res = dists[i];
            if (res == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(res);
            }
        }
    }
    
    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        Arrays.fill(dists, Integer.MAX_VALUE);
        pq.offer(new Node(start, 0));
        dists[start] = 0;
        
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            
            if (curr.dist > dists[curr.v]) {
                continue;
            }
            
            for (Node neighbor : graph[curr.v]) {
                int to = neighbor.v;
                int newDist = dists[curr.v] + neighbor.dist;
                
                if (newDist < dists[to]) {
                    dists[to] = newDist;
                    pq.offer(new Node(to, newDist));
                }
            }
        }
    }
}
