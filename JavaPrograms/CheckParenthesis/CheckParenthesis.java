public class CheckParenthesis {
	
	public boolean checker(String s) {
		MyStack ms = new MyStack();
		char[] arr = s.toCharArray();
		
		for (char c : arr) {
			//check if this char is open parenthesis
			if (c == '[' || c == '(') {
				ms.push(c);
			}
			// not open parenthesis
			else {
				if (ms.isEmpty()) {
					return false;
				} else if (!isPair(ms.pop(), c) ) {
					return false;
				}
			}
		}
		
		if ( ms.isEmpty() ) {
			return true;
		} else {
			return false;
		}
	}
	
	//helper method
	public boolean isPair(char c1, char c2) {
		if (c1 == '(' && c2 == ')') {
			return true;
		} else if (c1 == '[' && c2 == ']') {
			return true;
		} else {
			return false;
		}
	}

}
