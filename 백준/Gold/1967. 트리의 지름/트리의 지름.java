import java.io.*;
import java.util.*;

public class Main {
    
    static class Node {
        int v;
        int dist;
        
        Node(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }
    }
    
    static boolean[] visited;
    static List<Node>[] tree;
    static Node farthestNode = new Node(1, 0);
    static int maxDist;
    static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(token.nextToken());
        tree = new ArrayList[N + 1];
        for (int i = 0; i <= N; ++i) {
            tree[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < N - 1; ++i) {
            token = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(token.nextToken());
            int child = Integer.parseInt(token.nextToken());
            int dist = Integer.parseInt(token.nextToken());
            
            tree[parent].add(new Node(child, dist));
            tree[child].add(new Node(parent, dist));
        }
        
        visited = new boolean[N + 1];
        dfs(1, 0);
        
        Arrays.fill(visited, false);
        dfs(farthestNode.v, 0);
        
        System.out.print(maxDist);
        
    }
    
    private static void dfs(int current, int dist) {
        visited[current] = true;
        
        if (dist > maxDist) {
            maxDist = dist;
            farthestNode = new Node(current, dist);
        }
        
        for (Node neighbor : tree[current]) {
            int v = neighbor.v;
            if (!visited[v]) {
                dfs(v, dist + neighbor.dist);
            }
        }
    }
}














