class Solution {
    public int solution(int a, int b) {
        return Math.max(concat(a, b), concat(b, a));
    }
    
    public int concat(int a, int b) {
        return (a * (int)Math.pow(10, (int)Math.log10(b) + 1)) + b;
    }
}
