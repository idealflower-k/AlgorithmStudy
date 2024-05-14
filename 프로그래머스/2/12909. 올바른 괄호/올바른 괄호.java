import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> stack = new Stack<>();
        char[] charArr = s.toCharArray();
        
        for (int i = 0; i < charArr.length; i++) {
            if (!stack.isEmpty()) {
                if (stack.peek() == '(' && charArr[i] == ')') {
                    stack.pop();
                } else {
                    stack.push(charArr[i]);
                }
            } else {
                stack.push(charArr[i]);
            }
        }
        
        answer = stack.size() == 0 ? true : false;

        return answer;
    }
}