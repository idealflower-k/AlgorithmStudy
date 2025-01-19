import java.io.*;
import java.util.*;

public class Main {
    
    static List<Integer>[] graph;
    static int N;
    static int[] res;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(token.nextToken());
        graph = new ArrayList[N + 1];
        res = new int[N + 1];
        for (int i = 0; i <= N; ++i) {
            graph[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i < N - 1; ++i) {
            token = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(token.nextToken());
            int to = Integer.parseInt(token.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }
        
        bfs();
        for (int i = 2; i <= N; ++i) {
            sb.append(res[i]).append("\n");
        }
        System.out.print(sb);
    }
    
    private static void bfs() {
        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        res[1] = 1;
        
        while (!que.isEmpty()) {
            int curr = que.poll();
            
            for (int child : graph[curr]) {
                if (res[child] == 0) {
                    res[child] = curr;
                    que.add(child);
                }
            }
        }
    }
}
