class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visted = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visted[i]) {
                dfs(n, computers, i, visted);
                answer += 1;
            }   
        }
        return answer;
    }
    
    static void dfs(int n, int[][] computers, int curr, boolean[] visted) {
        visted[curr] = true;
        
        for (int i = 0; i < n; i++) {
            if (i != curr && computers[i][curr] == 1 && !visted[i]) {
                dfs(n, computers, i, visted);
            }
        }
    }
}