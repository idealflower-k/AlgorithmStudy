import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static int K;
    static int MAX = 100001;
    static int[] time;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());
        time = new int[MAX];
        Arrays.fill(time, -1);
        
        bfs();
        
        System.out.print(time[K]);
    }
    
    private static void bfs() {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(N);
        time[N] = 0;
        
        while (!deque.isEmpty()) {
            int curr = deque.poll();
            
            if (curr == K) {
                return;
            }
            
            int next = curr * 2;
            if (next < MAX && time[next] == -1) {
                time[next] = time[curr];
                deque.addFirst(next);
            }
            
            next = curr - 1;
            if (next >= 0 && time[next] == -1) {
                time[next] = time[curr] + 1;
                deque.addLast(next);
            }

            next = curr + 1;
            if (next < MAX && time[next] == -1) {
                time[next] = time[curr] + 1;
                deque.addLast(next);
            }
            
        }
    }
}
