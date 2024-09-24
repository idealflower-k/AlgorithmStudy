import java.util.*;

class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        boolean aIsOdd = (a % 2) == 1 ? true : false;
        boolean bIsOdd = (b % 2) == 1 ? true : false;
        
        if (aIsOdd && bIsOdd) {
            answer = (a * a) + (b * b);
        } else if (aIsOdd || bIsOdd) {
            answer = 2 * (a + b);
        } else {
            answer = Math.abs(a - b);
        }
        
        return answer;
    }
}