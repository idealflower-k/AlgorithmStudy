import java.io.*;
import java.util.*;

public class Main {
    
    static int[][] dp;
    static int[][] map;
    static int[][] dirs = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };
    static int M;
    static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(token.nextToken());
        N = Integer.parseInt(token.nextToken());
        
        map = new int[M][N];
        dp = new int[M][N];
        
        for (int i = 0; i < M; ++i) {
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; ++j) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        
        
        System.out.print(dfs(0, 0));
        
    }
    
    private static int dfs(int r, int c) {
        if (r == M - 1 && c == N - 1) {
            return 1;
        }
        
        if (dp[r][c] != -1) {
            return dp[r][c];
        }
        
        dp[r][c] = 0;
        
        for (int i = 0; i < 4; ++i) {
            int nr = r + dirs[i][0];
            int nc = c + dirs[i][1];
            
            if(isValid(nr, nc) && isLow(r, c, nr, nc)) {
                dp[r][c] += dfs(nr, nc);
            }
        }
        
        return dp[r][c];
    }
    
    private static boolean isValid(int r, int c) {
        return r >= 0 && c >= 0 && r < M && c < N;
    }
    
    private static boolean isLow(int r1, int c1, int r2, int c2) {
        return map[r1][c1] > map[r2][c2];
    }
}









