import java.io.*;
import java.util.*;

public class Main {
    
    static int[][] triangle;
    static int[][] dp;
    static int n;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(token.nextToken());
        triangle = new int[n][n];
        dp = new int[n][n];
        
        int line = 1;
        for (int i = 0; i < n; ++i) {
            Arrays.fill(dp[i], -1);
            Arrays.fill(triangle[i], -1);
            
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < line; ++j) {
                triangle[i][j] = Integer.parseInt(token.nextToken());
            }
            line++;
        }
        
        dp[0][0] = triangle[0][0];
        
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < n && triangle[i][j] != -1; ++j) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                } else if (j == n - 1 || triangle[i - 1][j] == -1) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                }
            }
        }
        
        int res = dp[n - 1][0];
        for (int i = 1; i < n; ++i) {
            res = Math.max(res, dp[n - 1][i]);
        }
        System.out.print(res);
    }
}

















