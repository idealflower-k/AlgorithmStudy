import java.io.*;
import java.util.*;

public class Main {
    
    static long[] dps;
    static long[][] bosses;
    static long[] maxExps;
    static int K;
    static int MAX_TIME = 900;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());
        
        dps = new long[N];
        bosses = new long[K][2];
        
        for (int i = 0; i < N; ++i) {
            dps[i] = Long.parseLong(br.readLine());
        }
        
        for (int i = 0; i < K; ++i) {
            token = new StringTokenizer(br.readLine());
            bosses[i][0] = Long.parseLong(token.nextToken());
            bosses[i][1] = Long.parseLong(token.nextToken());
        }
        
        maxExps = new long[N];
        for (int i = 0; i < N; ++i) {
            maxExps[i] = getMaxExp(dps[i]);
        }
        
        Arrays.sort(maxExps);
        
        long total = 0;
        for (int i = N - 1; i >= N - M; --i) {
            total += maxExps[i];
        }
        
        System.out.print(total);
    }
    
    private static long getMaxExp(long dmg) {
        int[] times = new int[K];
        long[] exps = new long[K];
        
        for (int i = 0; i < K; ++i) {
            long hp = bosses[i][0];
            long exp = bosses[i][1];
            
            long time = (hp + dmg - 1) / dmg;
            
            if (time <= MAX_TIME) {
                times[i] = (int)time;
                exps[i] = exp;
            } else {
                times[i] = MAX_TIME + 1;
                exps[i] = 0;
            }
        }
        
        long[] dp = new long[MAX_TIME + 1];
        
        for (int i = 0; i < K; ++i) {
            if (times[i] <= MAX_TIME) {
                for (int t = MAX_TIME; t >= times[i]; t--) {
                    dp[t] = Math.max(dp[t], dp[t - times[i]] + exps[i]);
                }
            }
        }
        return dp[MAX_TIME];
    }
}
