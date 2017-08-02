/**
	A class includes all methods that can be called from Driver
	@author Alice Zhang
**/

public class CarLinkedList {
	private Node head;
	private int count;

	public CarLinkedList() {
		head = null;
		count = 0;
	}

	//add car in sorted order
	public void addCar(Car c) {
		Node newNode = new Node(c);
		
		//if list is empty
		if (head == null) {
			head = newNode;
			count++;
		}

		//if list has one item
		else if (head.getNext() == null) {
			if (c.compareTo(head.getCar()) < 0) {
				newNode.setNext(head);
				head = newNode;
			} else {
				head.setNext(newNode);
			}
			count++;
		}

		else {
			Node previous = head;
			Node next = head.getNext();

			while ((next != null) && (c.compareTo(next.getCar()) > 0)) {
				previous = next;
				next = next.getNext();
			}
			newNode.setNext(next);
			previous.setNext(newNode);
			count++;
		}
	}

	//toString method for entile database
	public String toString() {
		String result = "";
		Node current = head;

		while(current != null) {
			if (current.getCar() instanceof GasCar) {
				result += ((GasCar)current.getCar()).getData() + "\n";
			} else if (current.getCar() instanceof GreenCar) {
				result += ((GreenCar)current.getCar()).getData() + "\n";
			}
			current = current.getNext();
		}
		return result;
	}

	//toString method for only Green Cars
	public String toStringGreenCars() {
		String result = "";
		Node current = head;

		while(current != null) {
			if (current.getCar() instanceof GreenCar) {
				result += ((GreenCar)current.getCar()).getData() + "\n";
			}
			current = current.getNext();
		}
		return result;
	}

	//method to compute average MPG for all Gas Cars
	public double avgMPG() {
		double totalMPG = 0;
		int size = 0;
		Node current = head;

		while(current != null) {
			if (current.getCar() instanceof GasCar) {
				totalMPG = totalMPG + ((GasCar)current.getCar()).getMPG();
				size++;
			}
			current = current.getNext();
		}
		double averageMPG = totalMPG / size;
		return averageMPG;
	}

	//method to compute average MPG by matching a specific model
	public double avgMpgByPartialModel(String inputString) {
		double totalMPG = 0;
		int size = 0;
		Node current = head;

		while (current != null) {
			if (current.getCar() instanceof GasCar) {
				if (current.getCar().getModel().contains(inputString)) {
					totalMPG = totalMPG + ((GasCar)current.getCar()).getMPG();
					size++;
				}
			}
			current = current.getNext();
		}
		double averageMPG = totalMPG / size;
		return averageMPG;
	}

	//a boolean method to check duplication
	public boolean ifDuplicated(String other, String[] temporary) {
		for (String s : temporary) {
			if (s != null && s.equals(other)) {
				return true;
			}
		}
		return false;
	}
	//find vehicle classes by matching the number of cylinders for Gas Cars
	public String[] findClassesByCylinders(int inputCylinders) {
		String[] list = new String[count];
		Node current = head;
		int i = 0;

		while (current != null) {
			if (current.getCar() instanceof GasCar) {
				if ( ((GasCar)current.getCar()).getNumberCylinders() == inputCylinders) {
					String match = current.getCar().getVehicleClass();
					if (!ifDuplicated(match, list)) {
						list[i] = match;
						i++;
					}
				}
			}
			current = current.getNext();
		}
		//saving them into a sorted array
		String[] newlist = new String[i];
		for (int j = 0; j < i; j++) {
			newlist[j] = list[j];
		}

		for (int a = 0; a < i; a++) {
			for (int b = 0; b < i; b++) {
				if (newlist[a].compareTo(newlist[b]) < 0) {
					String s = newlist[a];
					newlist[a] = newlist[b];
					newlist[b] = s;
				}
			}
		}
		return newlist;
	}

	//find models by matching a given vehicle class and a given MPG
	public String[] findModelsByClassAndMpg(String inputVehicleClass, int inputMPG) {
		String[] list = new String[count];
		Node current = head;
		int i = 0;

		while (current != null) {
			if (current.getCar() instanceof GasCar) {
				if (current.getCar().getVehicleClass().equals(inputVehicleClass) && ((GasCar)current.getCar()).getMPG() > inputMPG) {
					String match = current.getCar().getModel();
					list[i] = match;
					i++;
				}
			}
			current = current.getNext();
		}
		String[] newlist = new String[i];
		for (int j = 0; j < i; j++) {
			newlist[j] = list[j];
		}
		return newlist;
	}
}
