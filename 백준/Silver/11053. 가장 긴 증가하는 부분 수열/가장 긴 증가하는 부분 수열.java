import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        
        int result = 1;
        int N = Integer.parseInt(token.nextToken());
        int[] arr = new int[N];
        int[] dp = new int[N];
        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        
        Arrays.fill(dp, 1);
        
        for (int i = 1; i < N; ++i) {
            for (int j = 0; j < i; ++j) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        
        System.out.print(result);
    }
}
