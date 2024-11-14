import java.util.*;

class Solution {

    static int[] d = {1, -1};
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        int start1 = numbers[0];
        int start2 = 0 - numbers[0];
        
        answer += dfs(start1, numbers, target, 1);
        answer += dfs(start2, numbers, target, 1);
        
        return answer;
    }
    
    static int dfs(int currValue, int[] numbers, int target, int depth) {
        if (depth == numbers.length) {
            if (currValue == target)
                return 1;
            return 0;
        }
        int cnt = 0;
        for (int i = 0; i < 2; i++) {
            cnt += dfs(currValue + (d[i] * numbers[depth]), numbers, target, depth + 1);
        }
        return cnt;
    }
}


















