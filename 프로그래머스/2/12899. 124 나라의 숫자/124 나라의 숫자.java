import java.io.*;
import java.util.*;

class Solution {    
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        
        while (n > 0) {
            int rem = n % 3;
            
            if (rem == 0) {
                answer.insert(0, "4");
                n = n / 3 - 1;
            } else if (rem == 1) {
                answer.insert(0, "1");
                n = n / 3;
            } else if (rem == 2) {
                answer.insert(0, "2");
                n = n / 3;
            }
        }
        
        return answer.toString();
    }
}
