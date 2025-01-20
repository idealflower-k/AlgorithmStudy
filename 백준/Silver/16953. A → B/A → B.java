import java.io.*;
import java.util.*;

public class Main {
    
    static long A;
    static long B;
    static int res = -1;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        
        A = Long.parseLong(token.nextToken());
        B = Long.parseLong(token.nextToken());
        
        bfs();
        
        System.out.print(res);
    }
    
    private static void bfs() {
        Queue<Long> que = new LinkedList<>();
        que.add(A);
        int cnt = 1;
        
        while (!que.isEmpty()) {
            int len = que.size();
            for (int i = 0; i < len; ++i) {
                long curr = que.poll();
                long new1 = curr * 2;
                long new2 = (curr * 10) + 1;
                
                if (curr == B) {
                    res = cnt;
                    return;
                }
                
                if (new1 <= B) {
                    que.add(new1);
                }
                if (new2 <= B) {
                    que.add(new2);
                }
            }
            cnt++;
        }
    }
}
