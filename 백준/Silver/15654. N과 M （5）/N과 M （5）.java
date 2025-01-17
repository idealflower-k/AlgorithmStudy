import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static int M;
    static ArrayList<Integer> list = new ArrayList<>();
    static int[] num;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        
        num = new int[N];
        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            num[i] = Integer.parseInt(token.nextToken());
        }
        
        Arrays.sort(num);
        
        for (int i = 0; i < num.length; ++i) {
            list.add(num[i]);
            dfs();
            list.clear();
        }
        
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
        }
        
        for (int i = 0; i < num.length; ++i) {
            if (!list.contains(num[i])) {
                list.add(num[i]);
                dfs();
                list.remove(list.size() - 1);
            }
        }
    }
}