import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static int M;
    static List<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
            
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        
        dfs(1);
        
        System.out.print(sb);
    }
    
    private static void dfs(int num) {
        if (list.size() == M) {
            for (int i = 0; i < list.size(); ++i) {
                sb.append(list.get(i));
                if (i != list.size() - 1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
            return;
        }
        
        for (int i = num; i <= N; ++i) {
            list.add(i);
            dfs(i);
            list.remove(list.size() - 1);
        }
    }
}