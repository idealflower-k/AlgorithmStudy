class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = i == j ? 1 : 0;
                answer[i][j] = value;
            }
        }
        
        return answer;
    }
}