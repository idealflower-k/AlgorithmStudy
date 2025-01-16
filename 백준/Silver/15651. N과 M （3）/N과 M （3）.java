import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> list = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        
        
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        
        dfs();
        
        System.out.print(sb);
    }
    
    public static void dfs() {
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
        
        for (int i = 1; i <= N; ++i) {
            list.add(i);
            dfs();
            list.remove(list.size() - 1);
        }
    }
}