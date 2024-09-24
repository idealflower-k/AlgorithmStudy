class Solution {
    public String solution(String myString) {
        String answer = "";
        
        for (int i = 0; i < myString.length(); i++) {
            char value = myString.charAt(i);
            if (value < 'l') {
                value = 'l';
            }
            answer += value;
        }
        
        return answer;
    }
}