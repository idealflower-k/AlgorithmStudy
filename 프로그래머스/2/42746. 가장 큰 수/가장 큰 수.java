import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] strings = new String[numbers.length];
        
        for (int i = 0; i< numbers.length; i++) {
            strings[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b + a).compareTo(a + b);
            }
        });
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < strings.length; i++) {
            sb.append(strings[i]);
        }
        
        if (sb.charAt(0) == '0') {
            return "0";
        }
        
        return sb.toString();
    }
}