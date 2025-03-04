import java.io.*;
import java.util.*;

public class Main {
    
    static int col;
    static int row;
    static int[][] map;
    static int[][][] visited;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        
        row = Integer.parseInt(token.nextToken());
        col = Integer.parseInt(token.nextToken());
        
        map = new int[row][col];
        visited = new int[row][col][2];
        
        for (int i = 0; i < row; ++i) {
            token = new StringTokenizer(br.readLine());
            String line = token.nextToken();
            for (int j = 0; j < col; ++j) {
                map[i][j] = line.charAt(j) - '0';
                visited[i][j][0] = -1;
                visited[i][j][1] = -1;
            }
        }
        
        System.out.print(bfs());
    }
    
    private static int bfs() {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{0, 0, 0}); // row, col, wall
        visited[0][0][0] = 1;
        
        while (!que.isEmpty()) {
            int[] curr = que.poll();
            int r = curr[0];
            int c = curr[1];
            int wall = curr[2];
            
            if (r == row - 1 && c == col - 1) {
                return visited[r][c][wall];
            }
            
            for (int i = 0; i < 4; ++i) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if (!inRange(nr, nc)) {
                    continue;
                }
                
                if (map[nr][nc] == 1) {
                    if (wall == 0 && visited[nr][nc][1] == -1) {
                        visited[nr][nc][1] = visited[r][c][0] + 1;
                        que.offer(new int[]{nr, nc, 1});
                    }
                } else {
                    if (visited[nr][nc][wall] == -1) {
                        visited[nr][nc][wall] = visited[r][c][wall] + 1;
                        que.offer(new int[]{nr, nc, wall});
                    }
                }
            }
        }
        return -1;
    }
    
    private static boolean inRange(int r, int c) {
        return r >= 0 && c >= 0 && r < row && c < col;
    }
}