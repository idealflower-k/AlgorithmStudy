import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static int M;
    static int A;
    static int B;
    static int K;
    static boolean[][] map;
    static int[][] visited;
    static int[] start;
    static int[] end;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        A = Integer.parseInt(token.nextToken());
        B = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());
        
        map = new boolean[N + 1][M + 1];
        for (boolean[] arr : map) {
            Arrays.fill(arr, true);
        }
        visited = new int[N + 1][M + 1];
        for (int[] arr : visited) {
            Arrays.fill(arr, -1);
        }
        
        for (int i = 0; i < K; ++i) {
            token = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(token.nextToken());
            int col = Integer.parseInt(token.nextToken());
            map[row][col] = false;
        }
        
        start = new int[2];
        end = new int[2];
        token = new StringTokenizer(br.readLine());
        start[0] = Integer.parseInt(token.nextToken());
        start[1] = Integer.parseInt(token.nextToken());
        token = new StringTokenizer(br.readLine());
        end[0] = Integer.parseInt(token.nextToken());
        end[1] = Integer.parseInt(token.nextToken());
        
        System.out.print(bfs());
        
    }
    
    private static int bfs() {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{start[0], start[1]});
        visited[start[0]][start[1]] = 0;
        
        while (!que.isEmpty()) {
            int[] curr = que.poll();
            int r = curr[0];
            int c = curr[1];
            
            if (r == end[0] && c == end[1]) {
                return visited[r][c];
            }
            
            for (int i = 0; i < 4; ++i) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if (!inRange(nr, nc)) {
                    continue;
                }
                if (!isValid(nr, nc, i)) {
                    continue;
                }
                
                if (visited[nr][nc] == -1) {
                    que.offer(new int[]{nr, nc});
                    visited[nr][nc] = visited[r][c] + 1;
                }
            }
        }
        return -1;
    }
    
    private static boolean inRange(int r, int c) {
        return r >= 1 && c >= 1 && r + (A - 1) <= N && c + (B - 1) <= M;
    }
    
    private static boolean isValid(int r, int c, int dir) {
        if (dir == 0) {
            c += B - 1;
            for (int i = 0; i < A; ++i) {
                if (map[r][c] == false) {
                    return false;
                }
                r++;
            }
        } else if (dir == 1) {
            for (int i = 0; i < A; ++i) {
                if (map[r][c] == false) {
                    return false;
                }
                r++;
            }
        } else if (dir == 2) {
            for (int i = 0; i < B; ++i) {
                if (map[r][c] == false) {
                    return false;
                }
                c++;
            }
        } else if (dir == 3) {
            r += A - 1;
            for (int i = 0; i < B; ++i) {
                if (map[r][c] == false) {
                    return false;
                }
                c++;
            }
        }
        return true;
    }
}