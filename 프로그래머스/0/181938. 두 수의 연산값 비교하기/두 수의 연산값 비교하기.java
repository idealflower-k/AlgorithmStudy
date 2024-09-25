class Solution {
    public int solution(int a, int b) {
        return Math.max(concat(a, b), (2 * a * b));
    }
    
    public int concat(int a, int b) {
        return (a * (int)Math.pow(10, (int)Math.log10(b) + 1)) + b;
    }
}