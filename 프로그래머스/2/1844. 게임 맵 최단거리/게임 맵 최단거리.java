import java.util.*;

class Solution {
    static boolean[][] visted;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static int answer = Integer.MAX_VALUE;
    
    
    public int solution(int[][] maps) {
        int y = maps.length;
        int x = maps[0].length;
        visted = new boolean[y][x];
        
        bfs(maps);
        if (answer == Integer.MAX_VALUE)
            answer = -1;
        return answer;
    }
    
    static void bfs(int[][] maps) {
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{0, 0, 1});
        visted[0][0] = true;
        
        while (!queue.isEmpty()) {
            Integer[] temp = queue.poll();
            int currY = temp[0];
            int currX = temp[1];
            int currCost = temp[2];
            
            
            if (currY == maps.length - 1 && currX == maps[0].length - 1) {
                answer = Math.min(currCost, answer);
                continue;
            }
            
            for (int i = 0; i < 4; i++) {
                int nextY = currY + dy[i];
                int nextX = currX + dx[i];
                
                if ((nextY >= 0 && nextX >= 0) && (nextY < maps.length && nextX < maps[0].length) && maps[nextY][nextX] == 1 && !visted[nextY][nextX]) {
                    queue.add(new Integer[] {nextY, nextX, currCost + 1});
                    visted[nextY][nextX] = true;
                }
            }
        }
        
    }
}


















