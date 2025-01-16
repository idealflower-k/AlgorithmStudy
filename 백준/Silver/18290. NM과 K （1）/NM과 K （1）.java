import java.io.*;
import java.util.*;

public class Main {
    
    static int[][] map;
    static boolean[][] visited;
    static int N;
    static int M;
    static int K;
    static int result = Integer.MIN_VALUE;
    static int[][] dirs = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());
        
        map = new int[N][M];
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; ++i) {
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; ++j) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        
        dfs(0, 0, 0, 0);
        
        System.out.println(result);
        
    }
    
    public static void dfs(int r, int c, int cnt, int sum) {
        if (cnt == K) {
            result = Math.max(result, sum);
            return;
        }
        
        while (r < N && c < M) {
            if (isValid(r, c) && !visited[r][c] && canSet(r, c)) {
                visited[r][c] = true;
                dfs(r, c, cnt + 1, sum + map[r][c]);
                visited[r][c] = false;
            }
            c += 1;
            if (c >= M) {
                r += 1;
                c = 0;
            }
        }
    }
    
    public static boolean isValid(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }
    
    public static boolean canSet(int r, int c) {
        for (int i = 0; i < 4; ++i) {
            int[] dir = dirs[i];
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (isValid(nr, nc) && visited[nr][nc] == true) {
                return false;
            }
        }
        return true;
    }
}






