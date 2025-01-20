import java.io.*;
import java.util.*;

public class Main {
    
    static int[][] cost;
    static int[][] dp;
    static int n;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        
        int T = Integer.parseInt(token.nextToken());
        
        for (int i = 0; i < T; ++i) {
            n = Integer.parseInt(br.readLine());
            cost = new int[2][n];
            dp = new int[n][3];
            for (int j = 0; j < 2; ++j) {
                token = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; ++k) {
                    cost[j][k] = Integer.parseInt(token.nextToken());
                }
            }
            dp[0][0] = cost[0][0];
            dp[0][1] = cost[1][0];
            dp[0][2] = 0;
            
            for (int j = 1; j < n; ++j) {
                dp[j][0] = Math.max(dp[j - 1][1], dp[j - 1][2]) + cost[0][j];
                dp[j][1] = Math.max(dp[j - 1][0], dp[j - 1][2]) + cost[1][j];
                dp[j][2] = Math.max(dp[j - 1][0], dp[j - 1][1]);
            }
            
            int res = Math.max(Math.max(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);
            sb.append(res).append("\n");
        }
        System.out.print(sb);
    }
}
