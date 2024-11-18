import java.util.*;

class Solution {
    private final String[] VOWELS = {"A", "E", "I", "O", "U"};
    private int count = -1;
    private int answer = 0;

    public int solution(String word) {
        StringBuilder sb = new StringBuilder();
        dfs(sb, word);
        return answer;
    }

    private void dfs(StringBuilder sb, String word) {
        if (answer > 0 || sb.length() > 5) {
            return;
        }
        
        count++;
        
        if (sb.toString().equals(word)) {
            answer = count;
            return;
        }
        
        for (String vowel : VOWELS) {
            sb.append(vowel);
            dfs(sb, word);
            sb.setLength(sb.length() - 1);
        }
    }
}