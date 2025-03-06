    import java.io.*;
    import java.util.*;

    public class Main {
        
        static int[] parent;
        
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer token = new StringTokenizer(br.readLine());
            
            int N = Integer.parseInt(token.nextToken());
            int M = Integer.parseInt(br.readLine());
            parent = new int[N + 1];
            for (int i = 1; i <= N; ++i) {
                parent[i] = i;
            }
            
            for (int i = 1; i <= N; ++i) {
                token = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; ++j) {
                    int connect = Integer.parseInt(token.nextToken());
                    if (connect == 1) {
                        union(i, j);                
                    }
                }
            }
            
            token = new StringTokenizer(br.readLine());
            int[] plan = new int[M];
            for (int i = 0; i < M; ++i) {
                plan[i] = Integer.parseInt(token.nextToken());
            }
            
            for (int i = 0; i < M - 1; ++i) {
                if (find(plan[i]) != find(plan[i + 1])) {
                    System.out.print("NO");
                    return;
                }
            }
            
            System.out.print("YES");
        }
        
        private static void union(int a, int b) {
            int parentA = find(a);
            int parentB = find(b);
            
            if (parentA == parentB) {
                return;
            }
            
            parent[parentB] = parentA;
        }
        
        private static int find(int a) {
            if (a == parent[a]) {
                return a;
            }
            
            return parent[a] = find(parent[a]);
        }
    }
