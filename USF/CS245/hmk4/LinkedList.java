/**
 * A singly linked list with a dummy node. 
 * Fill in code inside methods:
 * printBackwards(), reverse(), deleteMiddleElement(), 
 * getKthNodeFromEnd(int k), findDecimalRepresentation() */
public class LinkedList {
	private Link head; // dummy node
	private Link tail; // the last node
	private int length; // the number of elements in the list, not counting the
						// dummy node

	/** Constructor: LinkedList */
	public LinkedList() {
		head = tail = new Link(); // a dummy head
		length = 0;
	}

	public Link head() {
		return head;
	}

	/** Return the size of the linked list */
	public int size() {
		return length;
	}

	/** Append a new node at the end of the list */
	public void add(Object elem) {
		tail.next = new Link(elem, null);
		tail = tail.next;
		length++;
	}

	/** Insert a new node at a given index */
	public void add(int index, Object elem) {
		if (index < 0 || index >= length) //
			System.out.println("Index not in list");
		// first we need to get to the node before the node with the given index
		Link tmp = head;
		for (int i = 0; i < index; i++) {
			tmp = tmp.next;
		}
		tmp.next = new Link(elem, tmp.next);
		length++;
	}

	/** Remove the node in a given position */
	public void remove(int index) {
		if (index < 0 || index >= length) {
			System.out.println("Index out of bounds");
			return;
		}
		// First, get to the node right before the node in position index
		Link tmp = head;
		for (int i = 0; i < index; i++) {
			tmp = tmp.next;
		}
		tmp.next = tmp.next.next;
		length--;
	}

	/** Remove the first occurrence of a given element */
	public void remove(Object elem) {
		// find the index of the first occurrence of the element
		Link tmp = head;
		while (tmp.next != null && !tmp.next.element.equals(elem)) {
			tmp = tmp.next;
		}
		// remove the node after it
		if (tmp.next != null) {
			tmp.next = tmp.next.next;
			length--;
		}

	}

	/**
	 * Print elements of this linked list in the opposite order (from last to
	 * first). Example: if the list is dummy->6->1->19->80, the method should
	 * print 80 19 1 6. Do not reverse the list. 
	 * Do not use an extra list. You may NOT use a get(i) method.
	 */

	public void printBackwards() {

		if (head.next == null) {
			return;
		}

		Link current = head.next;
		Link pointer = null; // a pointer to point to the last element in the list

		while (pointer != head.next) {
			while (current.next != pointer) {
				current = current.next;

			}
			pointer = current;
			System.out.print(pointer.element + "  ");
			current = head.next; // reset pointer to the first element
		}
		System.out.println();
		/*
		//Another way:
		int i = size() - 1;
		while (i >= 0) {
			//find element at index i
			Link tmp = head;
			int count = 0;
			while (tmp != null && (count <= i)) {
				tmp = tmp.next;
				count++;
			}
			System.out.println(tmp.element + " ");
			i--;
		}
		System.out.println();
		*/
	}

	/*
	//helper method for reverser():
	public Object removeAndReturn(int index) {
		if (index < 0 || index >= length) {
			System.out.println("Index out of bounds");
			return;
		}
		// First, get to the node right before the node in position index
		Link tmp = head;
		for (int i = 0; i < index; i++) {
			tmp = tmp.next;
		}
		Object elem = tmp.next.element;
		tmp.next = tmp.next.next;
		length--;
		return elem;
	}
	*/

	/**
	 * Reverse this list. Example: if this list is: dummy->7->19->6->4, the
	 * method should change it to dummy->4->6->19->7 You are allowed to use only
	 * O(1) extra space. 
	 * (You are NOT allowed to use an extra linked list, array,
	 * etc). 
	 */
	public void reverse() {
		
		Link previous = null;
		Link current = head.next;
		tail = current; //update tail

		while (current != null) {
			//move pointers
			Link nextOne = current.next;
			current.next = previous;
			previous = current;
			current = nextOne;
		}
		head.next = previous;

		/*
		//Another way:
		Link oldTail = tail;
		Link newHead = oldTail;
		int i = 0;
		int size = size();
		while (i < size - 1) {
			Object data = removeAndReturn(0);  //use the helper method
			newHead.next = new Link(data,newHead.next);
			i++;
		}
		//set new tail
		Link tmp = head.next;
		while (tmp != null && tmp.next != null) {
			tmp = tmp.next;
		}
		tail = tmp;
		*/
	}

	/**
	 * Remove the element in the middle of the list. You may assume the number of nodes is odd (not
	 * counting the dummy head). Example: if the input list is
	 * dummy->4->6->9->7->11, the method should remove 9. So the list will
	 * become: dummy->4->6->7->11 You are required to find a middle element in
	 * one pass using fast and slow pointers.
	 * 
	 */
	public void deleteMiddleElement() {
		
		Link p1 = head; //fast pointer
		Link p2 = head; //slow pointer
		while (p2 != null && p1 != null && p1.next != null) {
			p1 = p1.next.next;
			p2 = p2.next;
		}
		//p2.next = p2.next.next;
		//length--;
		System.out.println("middle = " + p2.element);
		remove(p2.element); //use the remove() method
	}

	/**
	 * Return the value of the k-th node from the end of the list. Example: if the list is:
	 * dummy->1->5->2->16->19->4, and k = 3 the method should return 16.
	 * Hint: Use two pointers; first move just one of them, 
	 * then start moving both.
	 */
	public Object getKthNodeFromEnd(int k) {
		// FILL IN CODE
		Link p1 = head; 
		Link p2 = head;

		//move the first pointer k times
		for (int i = 0; i < k; i++) {
			p1 = p1.next;
		}

		while (p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
	
		return p2.element; // don't forget to change this 
	}

	/**
	 * Assume this linked list stores either 0 or 1 at each node, 
	 * except for the dummy node. 
	 * Assume these 0s and 1s represent a binary number. 
	 * Return its decimal representation. 
	 * For instance, if the list is: dummy->1->0->1->1, 
	 * the method should return 11 (because 2^0 + 2^1 + 2^3 = 11).
	 * You may use casting to convert an Object element to an int.
	 * @param list
	 * @return
	 */
	public int findDecimalRepresentation() {
		int result = 0;
		int i = length - 1;
		// FILL IN CODE
		Link current = head.next;
		while (current != null) {
			int num = (int)current.element; //cast object to int
			int num2 = (int)Math.pow(2,i);
			result = result + (num * num2);
			current = current.next;
			i--;
		}
		
		return result;
	}


	/** Print elements of the list */
	public void print() {
		InnerIterator it = listIterator();
		while (it.hasNext()) {
			System.out.print(it.next() + "  ");
		}
		System.out.println();
	}

	/** Get the iterator for the list. Start with index 0. */
	public InnerIterator listIterator() {
		return new InnerIterator(0);
	}

	/**
	 * Get the iterator for the list. Start with the given index.
	 */
	public InnerIterator listIterator(int index) {
		return new InnerIterator(index);
	}

	/** Nested class Link. Represents a node in a linked list */
	private class Link {
		private Object element;
		private Link next;

		Link(Object elem, Link nextelem) {
			element = elem;
			next = nextelem;
		}

		Link() {
		}

	}

	/** Nested class -- InnerIterator */
	private class InnerIterator {
		private Link current; // the node before "next"

		/** Constructor: InnerIterator. Start iterator at a given index */
		public InnerIterator(int index) {
			// if index is 0, current will point at a dummy head
			current = head;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			// current will point at a node at index - 1
		}

		/** Return true if there is a "next" element */
		public boolean hasNext() {
			return current != null && current.next != null;
		}

		/** Return the value of the node right after current */
		public Object next() {
			if (!hasNext()) {
				System.out.println("No next element");
				return null;
			}
			current = current.next;
			return current.element;
		}
	}
}
