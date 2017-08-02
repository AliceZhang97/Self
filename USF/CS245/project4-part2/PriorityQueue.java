/** A min-heap implementation of a priority queue. */
public class PriorityQueue {
	private PriorityQueueElement[] heap; // min heap
	private int[] positions; // maps each node id to the index of the minheap

	private int maxsize;
	private int size;

	//class MinHeap
	public class MinHeap {

		public MinHeap(int max) {
			maxsize = max;
			heap = new PriorityQueueElement[maxsize];
			size = 0;
			heap[0] = new PriorityQueueElement(Integer.MIN_VALUE, Integer.MIN_VALUE); // no actual data is stored at heap[0]
		}

		//Return the index of the left child
		public int leftChild(int pos) {
			return 2 * pos;
		}

		//Return the index of right child 
		public int rightChild(int pos) {
			return 2 * pos + 1;
		}

		//Return the index of the parent
		public int parent(int pos) {
			return pos / 2;
		}

		//Return true if the node in a given position is a leaf
		public boolean isLeaf(int pos) {
			return ((pos > size / 2) && (pos <= size));
		}

		/** Swap given elements: one at index pos1, another at index pos2 */
		public void swap(int pos1, int pos2) {
			PriorityQueueElement tmp;
			tmp = heap[pos1];
			heap[pos1] = heap[pos2];
			heap[pos2] = tmp;
		}
	}

	MinHeap minHeap;
	/** Constructor. Takes the size of the heap array as a parameter */
	public PriorityQueue(int size) {
		// FILL IN
		minHeap = new MinHeap(size);
	}

	// FILL IN: add getters/setters as needed
	
	/**
	 * Insert (priority, nodeId) element into priority queue
	 */
	public void insert(int nodeId, int priority) {
		// FILL IN CODE
		PriorityQueueElement elem = new PriorityQueueElement(priority, nodeId);
		size++;
		heap[size] = elem;

		int current = size;
		while ( heap[current].compareTo( heap[minHeap.parent(current)] ) < 0 ) {
			minHeap.swap(current, minHeap.parent(current));
			current = minHeap.parent(current);
		}
	}

	//create the position array:
	public int[] createPositions() {
		positions = new int[heap.length - 1];
		for (int i = 0; i < positions.length; i++) {
			int index = heap[i + 1].getNodeId();
			positions[index] = i + 1;
		}
		return positions;
	}

	/**
	 * Remove the minimum element from the min heap (the element on top) and
	 * return its value.
	 */
	public int removeMin() {
		// FILL IN CODE
		minHeap.swap(1, size); //swap the end of the heap into the root
		size--; //remove the end of the heap

		//update the positions array
		positions[heap[1].getNodeId()] = 1;

		//fix the heap property - push down as needed
		if (size != 0) {
			pushdown(1);
		}
		int returnValue = heap[size + 1].getNodeId();

		return returnValue;
	}

	//Helper Method: pushdown
	private void pushdown(int position) {
		int smallestchild;
		while (!minHeap.isLeaf(position)) {
			smallestchild = minHeap.leftChild(position); // set the smallest child to left child
			if ( (smallestchild < size) && ( heap[smallestchild].compareTo( heap[smallestchild + 1] ) > 0 ) ) {
				smallestchild = smallestchild + 1; // right child was smaller, so smallest child = right child
			}

			//the value of the smallest child is less than value of current,
			//the heap is already valid
			if ( heap[position].compareTo(heap[smallestchild]) <= 0 ) {
				return;
			} 
			minHeap.swap(position, smallestchild);

			//update positions array
			positions[heap[position].getNodeId()] = position;
			positions[heap[smallestchild].getNodeId()] = smallestchild;

			position = smallestchild;
		}
	}

	/**
	 * Take a nodeId and a new priority for this nodeId. 
	 * new priority will be <= old priority. Update the min heap
	 * accordingly.
	 */
	public void reduceKey(int nodeId, int newPriority) {
		// FILL IN CODE
		int index = positions[nodeId];
		heap[index].setPriority(newPriority);

		//fix the min heap
		int current = index;
		while ( heap[current].compareTo( heap[minHeap.parent(current)] ) < 0 ) {
			minHeap.swap(current, minHeap.parent(current));
			//update positions array
			positions[heap[current].getNodeId()] = current;
			positions[heap[minHeap.parent(current)].getNodeId()] = minHeap.parent(current);

			current = minHeap.parent(current);
		}

	}
	// FILL IN: Add other helper methods as needed 
	// (such as "bubble down", etc.) */

}
