import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static int[][] map;
    static int[][] maxDp;
    static int[][] minDp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(token.nextToken());
        map = new int[N + 1][5];
        maxDp = new int[N + 1][5];
        minDp = new int[N + 1][5];
        
        Arrays.fill(minDp[0], 0);
        for (int i = 1; i <= N; ++i) {
            minDp[i][0] = Integer.MAX_VALUE;
            minDp[i][4] = Integer.MAX_VALUE;
        }
        
        for (int i = 1; i <= N; ++i) {
            token = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; ++j) {
                map[i][j] = Integer.parseInt(token.nextToken());
                int start = j - 1;
                maxDp[i][j] = Math.max(Math.max(maxDp[i - 1][start], maxDp[i - 1][start + 1]), maxDp[i - 1][start + 2]) + map[i][j];
                minDp[i][j] = Math.min(Math.min(minDp[i - 1][start], minDp[i - 1][start + 1]), minDp[i - 1][start + 2]) + map[i][j];
            }
        }
        
        int max = Math.max(Math.max(maxDp[N][1], maxDp[N][2]), maxDp[N][3]);
        int min = Math.min(Math.min(minDp[N][1], minDp[N][2]), minDp[N][3]);
        
        System.out.print(max + " " + min);
    }
}
