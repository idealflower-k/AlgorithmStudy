import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        
        
        for (int i = 0; i < progresses.length; i++) {
            double cost = Math.ceil((100 - progresses[i]) / (double) speeds[i]);
            progresses[i] = (int) cost;
        }
        
        int preCost = progresses[0];
        int cnt = 0;
        for (int i = 0; i < progresses.length; i++) {
            int cost = progresses[i];
            if (cost <= preCost) {
                cnt++;
            } else {
                list.add(cnt);
                cnt = 1;
            }
            preCost = Math.max(cost, preCost);
        }
        list.add(cnt);
        
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}