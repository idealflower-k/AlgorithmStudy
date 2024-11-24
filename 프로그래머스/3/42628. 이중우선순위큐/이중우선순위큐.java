import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];

        PriorityQueue<Integer> MaxQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> MinQ = new PriorityQueue<>();
        
        for (String oper : operations) {
            String[] op = oper.split(" ");
            int data = Integer.parseInt(op[1]);
            
            if (op[0].equals("I")) {
                MaxQ.offer(data);
                MinQ.offer(data);
            } else if (op[0].equals("D")) {
                if (data == 1 && !MaxQ.isEmpty()) {
                    int max = MaxQ.poll();
                    MinQ.remove(max);
                } else if (data == -1 && !MinQ.isEmpty()) {
                    int min = MinQ.poll();
                    MaxQ.remove(min);
                }
            }
        }
        
        if (!MaxQ.isEmpty()) {
            int max = MaxQ.poll();
            int min = MinQ.poll();
            answer[0] = max;
            answer[1] = min;
        }
        
        return answer;
    }
}