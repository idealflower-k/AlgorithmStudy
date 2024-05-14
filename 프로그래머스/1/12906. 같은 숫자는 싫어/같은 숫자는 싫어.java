import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        int preNum = arr[0];
        int idx = 1;
        list.add(preNum);
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == preNum) {
                continue;
            } else {
                preNum = arr[i];
                list.add(arr[i]);
                idx++;
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}