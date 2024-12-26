import java.util.*;
import java.io.*;

public class Main {
    
    static char[][] map;
    static boolean[][] visited;
    static int[][] dir = {
        {1, 0},
        {-1, 0},
        {0, -1},
        {0, 1}
    };
    static int[] value;
    static int N;
    static int M;
    
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        
        map = new char[M][N];
        visited = new boolean[M][N];
        value = new int[2];
        
        for (int i = 0; i < M; ++i) {
            String temp = buffer.readLine();
            map[i] = temp.toCharArray();
        }
        
        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                if (!visited[i][j]) {
                    bfs(i, j, map[i][j]);
                }
            }
        }
        
        for (int res : value) {
            System.out.print(res + " ");
        }
    }
    
    public static void bfs(int sy, int sx, char target) {
        Queue<int[]> que = new LinkedList<>();
        int result = 1;
        que.offer(new int[]{sy, sx});
        visited[sy][sx] = true;
        
        while (!que.isEmpty()) {
            int[] temp = que.poll();
            int y = temp[0];
            int x = temp[1];
            
            for (int i = 0; i < 4; ++i) {
                int nx = x + dir[i][1];
                int ny = y + dir[i][0];
                if (isValid(ny, nx) && !visited[ny][nx] && map[ny][nx] == target) {
                    result += 1;
                    visited[ny][nx] = true;
                    que.offer(new int[]{ny, nx});
                }
            }
        }
        
        if (target == 'W') {
            value[0] += result * result;
        } else {
            value[1] += result * result;
        }
    }
    
    public static boolean isValid(int y, int x) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}