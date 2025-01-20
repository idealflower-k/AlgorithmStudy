import java.io.*;
import java.util.*;

public class Main {
    
    static int[] weight;
    static int[] value;
    static int[] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        weight = new int[N + 1];
        value = new int[N + 1];
        dp = new int[K + 1];
        
        for (int i = 1; i <= N; ++i) {
            token = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(token.nextToken());
            value[i] = Integer.parseInt(token.nextToken());
        }
        
        for (int i = 1; i <= N; ++i) {
            for (int j = K; j >= weight[i]; --j) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        System.out.print(dp[K]);
    }
}
