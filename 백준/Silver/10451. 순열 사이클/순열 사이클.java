import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        
        int T = Integer.parseInt(token.nextToken());
        
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            token = new StringTokenizer(br.readLine());
            int[] arr = new int[N + 1];

            for (int i = 1; i <= N; ++i) {
                arr[i] = Integer.parseInt(token.nextToken());
            }
            
            boolean[] visited = new boolean[N + 1];
            
            int cnt = 0;
            for (int i = 1; i <= N; ++i) {
                if (visited[i]) {
                    continue;
                }
                dfs(i, arr, visited);
                cnt++;
            }
            System.out.println(cnt);
        }
    }
    
    private static void dfs(int node, int[] arr, boolean[] visited) {
        visited[node] = true;
        int next = arr[node];
        
        if (!visited[next]) {
            dfs(next, arr, visited);
        }
    }
}
