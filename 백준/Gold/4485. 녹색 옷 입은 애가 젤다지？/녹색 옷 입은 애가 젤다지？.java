import java.io.*;
import java.util.*;

public class Main {
    
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(token.nextToken());
        int cnt = 1;
        while (N != 0) {
            int[][] map = new int[N][N];
            for (int i = 0; i < N; ++i) {
                token = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; ++j) {
                    map[i][j] = Integer.parseInt(token.nextToken());
                }
            }
            
            int cost = bfs(N, map);
            System.out.println("Problem " + cnt + ": " + cost);
            N = Integer.parseInt(br.readLine());
            cnt++;
        }
    }
    
    private static int bfs(int N, int[][] map) {
        PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int[][] visited = new int[N][N];
        for (int[] arr : visited) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        que.offer(new int[]{0, 0, map[0][0]});
        visited[0][0] = map[0][0];
        
        while (!que.isEmpty()) {
            int[] curr = que.poll();
            int y = curr[0];
            int x = curr[1];
            int cost = curr[2];
            
            if (y == N - 1 && x == N - 1) {
                return cost;
            }
            
            for (int i = 0; i < 4; ++i) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (!inRange(nx, ny)) {
                    continue;
                }
                
                if (visited[ny][nx] > cost + map[ny][nx]) {
                    visited[ny][nx] = cost + map[ny][nx];
                    que.offer(new int[]{ny, nx, cost + map[ny][nx]});
                }
            }
        }
        return visited[N - 1][N - 1];
    }
    
    private static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}
