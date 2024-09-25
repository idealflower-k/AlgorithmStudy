class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int i = n; i > 0; i -= 2) {
            if (i % 2 == 0) {
                answer += (int)Math.pow(i, 2);    
            } else {
                answer += i;
            }    
        }
        return answer;
    }
}