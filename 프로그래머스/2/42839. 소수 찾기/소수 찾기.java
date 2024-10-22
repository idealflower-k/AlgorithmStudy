import java.util.*;

class Solution {
    static int answer = 0;
    static Set<String> sets = new HashSet<>();

    public int solution(String numbers) {
        combi("", numbers);

        return sets.size();
    }
    
    public void combi(String prefix, String remaining) {
        int n = remaining.length();
        
        if (!prefix.isEmpty()) {
            int value = Integer.parseInt(prefix);
            if (isPrime(value)) {
                sets.add(String.valueOf(value));    
            }
        }
        
        for (int i = 0; i < n; i++) {
            combi(prefix + remaining.charAt(i),
                  remaining.substring(0, i) + remaining.substring(i + 1, n));
        }
    }
    
    public boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        
        if (num == 2) {
            return true;
        }
        
        if (num % 2 == 0) {
            return false;
        }
        
        int sqrt = (int) Math.sqrt(num);
        for (int i = 3; i <= sqrt; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}