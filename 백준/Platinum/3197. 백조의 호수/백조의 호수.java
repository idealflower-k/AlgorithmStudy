import java.io.*;
import java.util.*;

public class Main {
    
    static char[][] map;
    static ArrayList<int[]> swans = new ArrayList<>();
    static Queue<int[]> waterQue = new LinkedList<>();
    static Queue<int[]> swanQue = new LinkedList<>();
    static boolean[][] visited;
    static int R;
    static int C;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        
        for (int i = 0; i < R; ++i) {
            String line = br.readLine();
            for (int j = 0; j < C; ++j) {
                char value = line.charAt(j);
                map[i][j] = value;
                if (value == 'L') {
                    swans.add(new int[]{i, j});
                    map[i][j] = '.';
                    waterQue.offer(new int[]{i, j});
                } else if (value == '.') {
                    waterQue.offer(new int[]{i, j});
                }
            }
        }
        
        int[] start = swans.get(0);
        swanQue.offer(new int[]{start[0], start[1]});
        visited[start[0]][start[1]] = true;
        
        int cnt = 0;
        while (!meetSwan()) {
            meltIce();
            cnt++;
        }
        
        System.out.print(cnt);
    }
    
    private static void meltIce() {
        int size = waterQue.size();
        
        for (int i = 0; i < size; ++i) {
            int[] curr = waterQue.poll();
            int y = curr[0];
            int x = curr[1];
            
            for (int j = 0; j < 4; ++j) {
                int ny = y + dy[j];
                int nx = x + dx[j];
                
                if (!inRange(ny, nx) || map[ny][nx] == '.') {
                    continue;
                }
                
                map[ny][nx] = '.';
                waterQue.offer(new int[]{ny, nx});
            }
        }
    }
    
    private static boolean meetSwan() {
        Queue<int[]> nextQue = new LinkedList<>();
        int[] end = swans.get(1);
        
        while (!swanQue.isEmpty()) {
            int[] curr = swanQue.poll();
            int y = curr[0];
            int x = curr[1];
            
            if (y == end[0] && x == end[1]) {
                return true;
            }
            
            for (int i = 0; i < 4; ++i) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if (!inRange(ny, nx) || visited[ny][nx]) {
                    continue;
                }
                
                visited[ny][nx] = true;
                
                if (map[ny][nx] == '.') {
                    swanQue.offer(new int[]{ny, nx});
                } else {
                    nextQue.offer(new int[]{ny, nx});
                }
            }
        }
        swanQue = nextQue;
        return false;
    }
    
    private static boolean inRange(int y, int x) {
        return x >= 0 && y >= 0 && x < C && y < R;
    }
}
