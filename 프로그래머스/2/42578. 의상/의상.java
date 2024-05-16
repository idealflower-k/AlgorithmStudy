import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String[] data : clothes) {
            if (map.containsKey(data[1])) {
                map.replace(data[1], map.get(data[1]) + 1);
            } else {
                map.put(data[1], 1);
            }
        }
        
        Collection<Integer> values = map.values();
        
        for (Integer value : values) {
            answer *= (value + 1);
        }
        
        return answer - 1;
    }
}