import java.util.*;

class Solution {
    public int solution(String[] order) {
        int answer = 0;
        String AME = "americano";
        String ANY = "anything";
        
        
        for (int i = 0; i < order.length; i++) {
            String menu = order[i];
            if (menu.contains(AME) || menu.contains(ANY)) {
                answer += 4500;
            } else {
                answer += 5000;
            }
        }
        
        return answer;
    }
}