/** A class that implements two stacks using one array. Fill in the code. */
public class TwoStacksOneArray implements TwoStacks {
	private Object[] data; // an array stores both stacks
	private int top1, top2; // the tops of the stacks
	private int size; 
			// the maximum number of elements the array can hold (the total size of both stacks)

	/**
	 * Constructor. Allocates memory for the stack. Initializes top1 and top2.
	 */
	public TwoStacksOneArray(int size) {
		data = new Object[size];
		this.size = size;
		// FILL IN CODE: assign initial values to top1 and top2
		top1 = 0;
		top2 = size - 1;

	}

	/** Push a given element onto the first stack */
	@Override
	public void pushFirst(Object elem) {
		if (top1 > top2) {
			System.out.println("Both stacks are full."); // check when stacks are full.
		}

		data[top1] = elem; //push the element to the top of the frist stack
		top1++; //increment top1

	}

	/** Push a given element onto the second stack */
	@Override
	public void pushSecond(Object elem) {
		if (top1 > top2) {
			System.out.println("Both stacks are full."); // check when stacks are full.
		}
		data[top2] = elem; //push the element to the top of the second stack
		top2--; //increment top2

	}

	/** Pop the element from the top of the first stack */
	@Override
	public Object popFirst() {
		//check if the first stack is empty
		if (top1 == 0) {
			System.out.println("The first stack is empty");
			return null;
		}

		Object tem = data[top1 - 1]; //save as a temporary variable
		top1 = top1 - 1;
		data[top1] = null; //set the top one to null
		return tem;

	}

	/** Pop the element from the top of the second stack */
	@Override
	public Object popSecond() {
		if (top2 == data.length - 1) {
			System.out.println("second stack is empty");
			return null;
		}

		Object tem = data[top2 + 1]; //save as a temporary variable
		top2 = top2 + 1;
		data[top2] = null; //set the top one to null
		return tem;
	}

	public String toString() {
		String s = " ";
		for (Object obj : data) {
			s = s + obj + "  ";
		}
		return s;
	}

	/** Return true if the first stack is empty, false otherwise */
	@Override
	public boolean isFirstEmpty() {
		return top1 == 0;
	}

	/** Return true if the second stack is empty, false otherwise */
	@Override
	public boolean isSecondEmpty() {
		// FILL IN CODE
		return top2 == size - 1;
	}

}
