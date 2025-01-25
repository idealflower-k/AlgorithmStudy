import java.io.*;
import java.util.*;

public class Main {
    
    static class Node implements Comparable<Node> {
        int r;
        int c;
        int dir;
        int mirrors;
        
        Node(int r, int c, int dir, int mirrors) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.mirrors = mirrors;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.mirrors - o.mirrors;
        }
    }
    
    static char[][] map;
    static int[][][] dist;
    static int[][] dirs = {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };
    static List<int[]> cPos = new ArrayList<>();
    static int W;
    static int H;
    static int[] start;
    static int[] end;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        
        W = Integer.parseInt(token.nextToken());
        H = Integer.parseInt(token.nextToken());
        map = new char[H][W];
        dist = new int[H][W][4];
        
        for (int i = 0; i < H; ++i) {
            String line = br.readLine();
            for (int j = 0; j < W; ++j) {
                char value = line.charAt(j);
                if (value == 'C') {
                    cPos.add(new int[]{i, j});
                } else if (value == '*') {
                    map[i][j] = value;
                } else if (value == '.') {
                    map[i][j] = value;
                }
            }
        }
        
        start = cPos.get(0);
        end = cPos.get(1);
        
        for (int i = 0; i < H; ++i) {
            for (int j = 0; j < W; ++j) {
                for (int k = 0; k < 4; ++k) {
                    dist[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        
        bfs();
    }
    
    private static void bfs() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < 4; ++i) {
            dist[start[0]][start[1]][i] = 0;
            pq.add(new Node(start[0], start[1], i, 0));
        }
        
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int r = curr.r;
            int c = curr.c;
            int dir = curr.dir;
            int mirrors = curr.mirrors;
            
            if (r == end[0] && c == end[1]) {
                System.out.print(mirrors);
                return;
            }
            
            if (mirrors > dist[r][c][dir]) {
                continue;
            }
            
            for (int i = 0; i < 4; ++i) {
                int nr = r + dirs[i][0];
                int nc = c + dirs[i][1];
                
                if (!isValid(nr, nc) || map[nr][nc] == '*') {
                    continue;
                }
                
                int nm = mirrors + ((dir == i) ? 0 : 1);
                
                if (nm < dist[nr][nc][i]) {
                    dist[nr][nc][i] = nm;
                    pq.add(new Node(nr, nc, i, nm));
                }
            }
        }
    }
    
    private static boolean isValid(int r, int c) {
        return r >= 0 && c >= 0 && r < H && c < W;
    }
}
