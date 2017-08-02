/** Edge class represents an edge in the adjacency list of the graph. 
  * Implements Comparable. Compares Edges based on the cost. */
class Edge implements Comparable<Edge> {
    private int id1; //source vertex
    private int id2; //destination vertex 
	private int cost;
	private Edge next;
	
	Edge(int id1, int id2, int cost){
		// FILL IN CODE
		this.id1 = id1;
		this.id2 = id2;
		this.cost = cost;
		next = null;
	}
	
	// FILL IN CODE: add getters and setters as needed
	public int getId1() {
		return this.id1;
	}
	public int getId2() {
		return this.id2;
	}
	public int getCost() {
		return this.cost;
	}
	public void setNext(Edge anotherEdge) {
		this.next = anotherEdge;
	}
	public Edge next() {
		return next;
	}

	/** Compare edges based on their cost */
	//@Override
	int c;
	public int compareTo(Edge o) {
		// FILL IN CODE
		if (this.cost < o.getCost()) {
			c = -1;
		} else if (this.cost > o.getCost()) {
			c = 1;
		}
		
		return c; // change!
	}
	
         
 }
