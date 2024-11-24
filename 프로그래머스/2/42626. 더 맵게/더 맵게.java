import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>();
        
        for(int data : scoville) {
            que.offer(data);
        }
        
        while (true) {
            int data = que.poll();
            if (data < K && !que.isEmpty()) {
                int nextData = que.poll();
                int newData = data + (nextData * 2);
                que.offer(newData);
                answer++;
            } else {
                que.offer(data);
                break;
            }
        }
        
        if (que.poll() < K) {
            answer = -1;
        }
        
        return answer;
    }
}