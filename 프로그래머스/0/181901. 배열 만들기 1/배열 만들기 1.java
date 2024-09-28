class Solution {
    public int[] solution(int n, int k) {
        int[] answer;
		answer = new int[n / k];
		int cnt = 0;

		for (int i = 1; i <= n; i++) {
			if (i % k == 0) {
				answer[cnt++] = i;
			}
		}

		return answer;
    }
}