import java.util.*;

class Solution {
    
    class Node {
        public int value;
        public boolean target;
        
        Node (int value, boolean target) {
            this.value = value;
            this.target = target;
        }
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int[] sorted = Arrays.copyOf(priorities, priorities.length);
        Arrays.sort(sorted);
        int maxValue = sorted[priorities.length - 1];
        
        ArrayDeque<Node> que = new ArrayDeque<>();
        
        for (int i = 0; i < priorities.length; i++) {
            if (i == location) {
                que.offerLast(new Node(priorities[i], true));
            } else {
                que.offerLast(new Node(priorities[i], false));
            }
        }
            
        while (!que.isEmpty()) {
            Node node = que.pollFirst();

            if (node.value < maxValue) {
                que.offerLast(node);
            } else {
                answer += 1;
                if (node.target) {
                    break;
                }
                maxValue = sorted[(priorities.length - 1) - answer];
            }
        }
        
        return answer;
    }
}