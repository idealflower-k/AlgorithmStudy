import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static int M;
    static char[][] map;
    static int[][] dp;
    static int[] U = {-1, 0};
    static int[] R = {0, 1};
    static int[] D = {1, 0};
    static int[] L = {0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        
        map = new char[N][M];
        dp = new int[N][M];
        
        for (int i = 0; i < N; ++i) {
            String line = br.readLine();
            map[i] = line.toCharArray();
        }
        
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (dp[i][j] == -1) {
                    dp[i][j] = dfs(i, j);
                }
            }
        }
        
        int result = 0;
        for (int[] arr : dp) {
            for (int i : arr) {
                if (i == 1) {
                    result++;
                }
            }
        }
        System.out.print(result);
    }
    
    private static int dfs(int r, int c) {
        if (dp[r][c] != -1) {
            return dp[r][c];
        }
        
        char curr = map[r][c];
        int nr = r;
        int nc = c;
        if (curr == 'U') {
            nr = r + U[0];
            nc = c + U[1];
        } else if (curr == 'D') {
            nr = r + D[0];
            nc = c + D[1];
        } else if (curr == 'R') {
            nr = r + R[0];
            nc = c + R[1];
        } else if (curr == 'L') {
            nr = r + L[0];
            nc = c + L[1];
        }
        
        if (isOut(nr, nc)) {
            dp[r][c] = 1;
            return 1;
        } else {
            dp[r][c] = 0;
            dp[r][c] = dfs(nr, nc);
        }
        return dp[r][c];
    }
    
    private static boolean isOut(int r, int c) {
        return r < 0 || c < 0 || r >= N || c >= M;
    }
}
