public class MyStack {
	//no more than 10000 chars
	char[] list = new char[10000];
	int top = 0;
	
	public void push(char c) {
		if (top >= 9999) {
			System.out.println("Stack is full.");
		} else {
			list[top] = c;
			top++;
		}
	}
	
	public char pop() {
		if (top < 0) {
			System.out.println("Cannot pop element.");
			return '\0';
		} else {
			char returnValue = list[top-1];
			top--;
			return returnValue;
		}
	}
	
	public boolean isEmpty() {
		if (top == 0) {
			return true;
		} else {
			return false;
		}
	}
}
