class Solution {
    public String solution(String code) {
        StringBuilder answer = new StringBuilder();
	    boolean zero = true;    
    
	    for (int i = 1; i <= code.length(); i++) {
		    char currChar = code.charAt(i - 1);
		    int idx = i - 1;

		    if (zero && currChar != '1' && (idx % 2) == 0) {
			    answer.append(currChar);
		    } else if (!zero && currChar != '1' && (idx % 2) == 1) {
    			answer.append(currChar);
	    	} else if (currChar == '1') {
		    	zero = !zero;
		    }
	    }
		if (answer.length() == 0) {
			return "EMPTY";
		}
	    return answer.toString();
    }
}