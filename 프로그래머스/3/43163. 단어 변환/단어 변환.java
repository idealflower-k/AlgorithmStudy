import java.io.*;
import java.util.*;


class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<String> que = new LinkedList<>();
        HashSet<String> set = new HashSet<>(Arrays.asList(words));
        
        if (!set.contains(target)) {
            return 0;
        }
        
        que.add(begin);
        set.remove(begin);
        
        while (!que.isEmpty()) {
            
            for (int i = 0; i < que.size(); i++) {
                String curr = que.poll();
                
                if (curr.equals(target)) {
                    return answer;
                }
                
                String[] arr = set.toArray(new String[set.size()]);
                for (String next : arr) {
                    if (canConvert(curr, next)) {
                        que.add(next);
                        set.remove(next);
                    }
                }
            }
            answer++;
        }
        
        return answer;
    }
    
    public boolean canConvert(String curr, String next) {
        int diff = 0;
        
        for (int i = 0; i < curr.length(); i++) {
            if (curr.charAt(i) != next.charAt(i)) {
                diff++;
            }
        }
        
        return diff == 1;
    }
}