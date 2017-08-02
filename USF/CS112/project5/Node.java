/**
	A class to set up Node for LinkedList that containing a Car
	@author Alice Zhang
**/

public class Node {

	//properties
	private Car car;
	private Node next;

	public Node(Car car) {
		this.car = car;
		this.next = null;
	}

	//setters
	public void setNext(Node next) {
		this.next = next;
	}
	public void setCar(Car car) {
		this.car = car;
	}

	//getters
	public Car getCar() {
		return this.car;
	}
	public Node getNext() {
		return this.next;
	}
}
