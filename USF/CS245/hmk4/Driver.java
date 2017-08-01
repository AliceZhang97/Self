/** A Driver class to test your LinkedList class methods */
public class Driver {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(5);
		list.add(19);
		list.add(27);
		list.add(1);
		list.add(65);
		list.add(181);
		list.print();
		System.out.println("After printing backwards:");
		list.printBackwards();
		System.out.println("--------------");
		System.out.println("Start with this list: ");
		list.print();
		System.out.println("After reversing it: ");
		list.reverse();
		list.print();
		System.out.println("--------------");
		list.add(89);
		System.out.println("Start with this list: ");
		list.print();
		list.deleteMiddleElement();
		System.out.println("After deleting middle element: ");
		list.print();
		System.out.println("--------------");
		System.out.print("4th node from the end is: ");
		System.out.println(list.getKthNodeFromEnd(4));
		
		list = new LinkedList();
		list.add(1);
		list.add(0);
		list.add(1);
		list.add(1);
		System.out.println("--------------");
		System.out.println("A list that contains 0s and 1s:");
		list.print();
		System.out.print("Decimal representation: ");
		System.out.println(list.findDecimalRepresentation());
		System.out.println("-------------");
		

	}
}
