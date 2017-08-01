
public class Driver {
	public static void main(String[] args) {
		// Test reverse() method that reverses a queue
		System.out.println("Testing QueueUtils.reverse method ------");
		ArrayQueue q1 = new ArrayQueue();
		ArrayQueue q2 = new ArrayQueue();
		q1.enqueue(14);
		q1.enqueue(45);
		q1.enqueue(87);
		q1.enqueue(9);
		q1.enqueue(3);
		System.out.println("Before reversing: \n" +  q1);
		QueueUtils.reverse(q1, q2);
		System.out.println("After reversing: \n" +  q2);
		System.out.println();
		
		// Test the two stacks problem
		System.out.println("Testing the two stacks problem. Enqueue several elements to each stack ------");
		TwoStacksOneArray twoS = new TwoStacksOneArray(10);
		twoS.pushFirst(1);
		twoS.pushFirst(2);
		twoS.pushFirst(3);
		twoS.pushSecond(5);
		twoS.pushSecond(6);
		twoS.pushFirst(4);
		twoS.pushSecond(7);
		System.out.println(twoS);

		System.out.println("Calling popFirst(): " + twoS.popFirst());
		System.out.println("Calling popSecond(): " + twoS.popSecond());

		System.out.println("Calling popFirst(): " + twoS.popFirst());
		System.out.println("Calling popSecond(): " + twoS.popSecond());
		System.out.println("Print the two stacks: ");
		System.out.println(twoS);

	}
}
