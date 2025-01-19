import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static int M;
    static int[] arr;
    static int[] list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        arr = new int[N];
        list = new int[M];

        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        
        Arrays.sort(arr);
        dfs(0, 0);
        
        System.out.print(sb);
    }
    
    private static void dfs(int start, int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; ++i) {
                sb.append(list[i]);
                if (i != M - 1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
            return;
        }
        
        int lastUsed = -1;
        for (int i = start; i < N; ++i) {
            if (arr[i] != lastUsed) {
                list[cnt] = arr[i];
                lastUsed = arr[i];
                dfs(i, cnt + 1);
            }
        }
    }
}
