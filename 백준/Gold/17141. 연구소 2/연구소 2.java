import java.util.*;
import java.io.*;

public class Main {
    
    static ArrayList<int[]> locs = new ArrayList<>();
    static ArrayList<int[]> selected = new ArrayList<>();
    static boolean[] viVisited;
    static boolean[][] visited;
    static int[][] map;
    static int empty;
    static int[][] dir = {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };
    static int min = Integer.MAX_VALUE;
    static int N;
    static int M;
    
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; ++i) {
            token = new StringTokenizer(buffer.readLine());
            for (int j = 0; j < N; ++j) {
                int value = Integer.parseInt(token.nextToken());
                if (value == 2) {
                    locs.add(new int[]{i, j});
                }
                if (value != 1) {
                    empty += 1;
                }
                map[i][j] = value;
            }
        }
        
        viVisited = new boolean[locs.size()];
        
        dfs(0, 0);
        if (min == Integer.MAX_VALUE) {
            min = -1;
        }
        System.out.print(min);
    }
    
    public static void dfs(int start, int cnt) {
        if (cnt == M) {
            bfs();
            
            return;
        }
        
        for (int i = start; i < locs.size(); ++i) {
            if (!viVisited[i]) {
                viVisited[i] = true;
                selected.add(locs.get(i));
                dfs(i + 1, cnt + 1);
                viVisited[i] = false;
                selected.remove(selected.size() - 1);
            }
        }
    }
    
    public static void bfs() {
        Queue<int[]> que = new LinkedList<>();
        for (boolean[] arr : visited) {
            Arrays.fill(arr, false);
        }
        int fill = 0;
        int time = 0;
        for (int i = 0; i < selected.size(); ++i) {
            int[] temp = selected.get(i);
            que.offer(temp);
            visited[temp[0]][temp[1]] = true;
        }
        
        while (!que.isEmpty()) {
            int queSize = que.size();
            boolean spread = false;
            for (int i = 0; i < queSize; ++i) {
                int[] temp = que.poll();
                int y = temp[0];
                int x = temp[1];
                
                for (int j = 0; j < 4; ++j) {
                    int ny = y + dir[j][0];
                    int nx = x + dir[j][1];
                    if (isValid(ny, nx) && !visited[ny][nx] && map[ny][nx] != 1) {
                        visited[ny][nx] = true;
                        que.offer(new int[]{ny, nx});
                        fill++;
                        spread = true;
                    }
                }
            }
            if (spread) {
                time++;
            }
            if (fill == empty - M) {
                min = Math.min(min, time);
            }
            if (time >= min) {
                return;
            }
        }
    }
    
    public static boolean isValid(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < N;
    }
}



















