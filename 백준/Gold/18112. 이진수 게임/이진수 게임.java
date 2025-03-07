import java.io.*;
import java.util.*;

public class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int start = Integer.parseInt(br.readLine(), 2);
        int target = Integer.parseInt(br.readLine(), 2);
        
        int result = bfs(start, target);
        System.out.print(result);
    }
    
    private static int bfs(int start, int end) {
        Queue<int[]> que = new ArrayDeque<>();
        boolean[] visited = new boolean[1024];

        que.offer(new int[]{start, 0});
        visited[start] = true;
        
        while (!que.isEmpty()) {
            int[] curr = que.poll();
            int num = curr[0];
            int cnt = curr[1];
            
            if (num == end) {
                return cnt;
            }
            
            String binary = Integer.toBinaryString(num);
            int len = binary.length();
            for (int i = 1; i < len; ++i) {
                int pos = len - 1 - i;
                int mask = 1 << pos;
                int flipped = num ^ mask;
                
                if (!visited[flipped]) {
                    visited[flipped] = true;
                    que.offer(new int[]{flipped, cnt + 1});
                }
            }
            
            int plus = num + 1;
            if (plus < 1024 && !visited[plus]) {
                visited[plus] = true;
                que.offer(new int[]{plus, cnt + 1});
            }
            
            if (num > 0) {
                int minus = num - 1;
                if (!visited[minus]) {
                    visited[minus] = true;
                    que.offer(new int[]{minus, cnt + 1});
                }
            }
        }

        return -1;        
    }
}
