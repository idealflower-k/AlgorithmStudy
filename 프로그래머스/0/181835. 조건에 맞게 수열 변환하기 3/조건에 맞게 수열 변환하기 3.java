class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[arr.length];
        boolean odd = (k % 2) == 1 ? true : false;
        
        for (int i = 0; i < arr.length; i++) {
            if (odd) {
                answer[i] = arr[i] * k;
            } else {
                answer[i] = arr[i] + k;
            }
        }

        return answer;
    }
}