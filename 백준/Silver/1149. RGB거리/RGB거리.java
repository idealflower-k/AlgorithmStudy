import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static int[][] cost;
    static int[][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(token.nextToken());
        cost = new int[N][3];
        dp = new int[N][3];
        
        for (int i = 0; i < N; ++i) {
            token = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(token.nextToken());
            int G = Integer.parseInt(token.nextToken());
            int B = Integer.parseInt(token.nextToken());
            cost[i][0] = R;
            cost[i][1] = G;
            cost[i][2] = B;
        }
        
        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];
        
        for (int i = 1; i < N; ++i) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
        }
        
        int res = Math.min(Math.min(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]);
        
        System.out.print(res);
    }
}
