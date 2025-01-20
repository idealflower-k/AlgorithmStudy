import java.io.*;
import java.util.*;

public class Main {
    
    static String A;
    static String B;
    static int[][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        A = br.readLine();
        B = br.readLine();
        
        dp = new int[A.length() + 1][B.length() + 1];
        
        for (int i = 1; i <= A.length(); ++i) {
            for (int j = 1; j <= B.length(); ++j) {
                if (A.charAt(i - 1) != B.charAt(j - 1)) {
                    dp[i][j] = Math.max(dp[i- 1][j], dp[i][j - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }
        
        System.out.print(dp[A.length()][B.length()]);
    }
}
