class Solution {
    public int solution(int n, String control) {
        int answer = n;

		for (int i = 0; i < control.length(); i++) {
			char c = control.charAt(i);
			if (c == 'w') {
				answer += 1;
			} else if (c == 's') {
				answer -= 1;
			} else if (c == 'd') {
				answer += 10;
			} else if (c == 'a') {
				answer -= 10;
			}
		}
		return answer;
    }
}