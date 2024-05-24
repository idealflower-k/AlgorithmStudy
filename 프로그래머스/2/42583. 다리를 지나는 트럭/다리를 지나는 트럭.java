import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int currWeight = 0;
        
        Queue<Integer> que = new LinkedList<>();
        
        for (int value : truck_weights) {
            while (true) {
                if (que.isEmpty()) {
                    que.add(value);
                    answer++;
                    currWeight += value;
                    break;
                } else if (que.size() == bridge_length) {
                    currWeight -= que.poll();
                } else {
                    if (currWeight + value <= weight) {
                        que.add(value);
                        currWeight += value;
                        answer++;
                        break;
                    } else {
                        que.add(0);
                        answer++;
                    }
                }
            }
        }
        
        return answer + bridge_length;
    }
}