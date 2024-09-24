class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length * k];
        
        int targetIdx = 0;
        for (int i = 0; i < picture.length; i++) {
            String temp = picture[i];
            String newLine = "";
            for (int j = 0; j < temp.length(); j++) {
                for (int x = 0; x < k; x++) {
                    newLine += temp.charAt(j);
                }
            }
            for (int x = 0; x < k; x++) {
                answer[targetIdx + x] = newLine;
            }
            targetIdx += k;
        }
        return answer;
    }
}
    