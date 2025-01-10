import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int[][] rooms;  // 방 번호 저장
    static List<Integer> roomSizes;  // 방 크기 저장
    static int[][] mv = {
        {0, -1},  // 서쪽(1)
        {-1, 0},  // 북쪽(2)
        {0, 1},   // 동쪽(4)
        {1, 0}    // 남쪽(8)
    };
    static int[] dirs = {1, 2, 4, 8};
    
    static int N, M;
    static int[] result;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        // 초기화
        map = new int[M][N];
        rooms = new int[M][N];
        roomSizes = new ArrayList<>();
        roomSizes.add(0);  // 0번 방은 사용하지 않음
        result = new int[3];
        
        // 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 방 탐색
        int roomNumber = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (rooms[i][j] == 0) {  // 아직 방문하지 않은 방
                    roomNumber++;
                    int size = bfs(i, j, roomNumber);
                    roomSizes.add(size);
                    result[0]++;  // 방의 개수
                    result[1] = Math.max(result[1], size);  // 가장 큰 방 크기
                }
            }
        }
        
        // 벽을 하나 제거했을 때 가장 큰 방 크기 찾기
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                for (int d = 0; d < 4; d++) {
                    int ni = i + mv[d][0];
                    int nj = j + mv[d][1];
                    
                    if (!isValid(ni, nj)) continue;
                    
                    // 서로 다른 방이고 벽이 있는 경우
                    if (rooms[i][j] != rooms[ni][nj] && isWall(map[i][j], dirs[d])) {
                        int sum = roomSizes.get(rooms[i][j]) + roomSizes.get(rooms[ni][nj]);
                        result[2] = Math.max(result[2], sum);
                    }
                }
            }
        }
        
        // 결과 출력
        for (int res : result) {
            System.out.println(res);
        }
    }
    
    static int bfs(int r, int c, int roomNum) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        rooms[r][c] = roomNum;
        int size = 1;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            for (int d = 0; d < 4; d++) {
                int nr = curr[0] + mv[d][0];
                int nc = curr[1] + mv[d][1];
                
                if (isValid(nr, nc) && rooms[nr][nc] == 0 && !isWall(map[curr[0]][curr[1]], dirs[d])) {
                    rooms[nr][nc] = roomNum;
                    q.offer(new int[]{nr, nc});
                    size++;
                }
            }
        }
        return size;
    }
    
    static boolean isWall(int cell, int dir) {
        return (cell & dir) != 0;
    }
    
    static boolean isValid(int r, int c) {
        return r >= 0 && c >= 0 && r < M && c < N;
    }
}