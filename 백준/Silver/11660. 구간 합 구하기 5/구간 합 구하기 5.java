import java.io.*;
import java.util.*;

public class Main {
    
    static int[][] board;
    static int[][] prefixSum;
    static StringBuilder sb = new StringBuilder();
    static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(token.nextToken());
        int T = Integer.parseInt(token.nextToken());
        board = new int[N + 1][N + 1];
        prefixSum = new int[N + 1][N + 1];
        
        for (int i = 1; i <= N; ++i) {
            token = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; ++j) {
                board[i][j] = Integer.parseInt(token.nextToken());
                prefixSum[i][j] = prefixSum[i][j - 1] + prefixSum[i - 1][j] - prefixSum[i - 1][j - 1] + board[i][j];
            }
        }
        
        for (int i = 0; i < T; ++i) {
            token = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(token.nextToken());
            int y1 = Integer.parseInt(token.nextToken());
            int x2 = Integer.parseInt(token.nextToken());
            int y2 = Integer.parseInt(token.nextToken());
            
            int res = prefixSum[x2][y2] - prefixSum[x1 - 1][y2] - prefixSum[x2][y1 - 1] + prefixSum[x1 - 1][y1 - 1];
            sb.append(res).append("\n");
        }
        
        System.out.print(sb);
    }
}
