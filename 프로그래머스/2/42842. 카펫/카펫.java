class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int area = brown + yellow;
        int width = area;
        int height = 1;
        
        while (width >= height) {
            if (width > 2 && height > 2) {
                int inside = (width - 2) * (height - 2);
                if (inside == yellow) {
                    answer[0] = width;
                    answer[1] = height;
                    break;
                }
            }
            while (true) {
                height++;
                width = area / height;
                if (height * width == area) {
                    break;
                }
            }
        }
        
        return answer;
    }
}