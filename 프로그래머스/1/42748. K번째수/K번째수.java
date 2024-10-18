import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        PriorityQueue<Integer> que = new PriorityQueue<>();
        
        for (int i = 0; i < commands.length; i++) {
            for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {
                que.offer(array[j]);
            }
            for (int k = 0; k < commands[i][2] - 1; k++) {
                que.poll();
            }
            answer[i] = que.poll();
            que.clear();
        }
        
        return answer;
    }
}