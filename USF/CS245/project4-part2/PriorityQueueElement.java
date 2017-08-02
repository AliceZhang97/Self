/** A class that represents an "entry" in the priority queue.
 * 	Implements Comparable (comparing by priority).
    PriorityQueueElement stores node id for a particular node in the graph 
    and priority of this node. Priority is the "cost" of the vertex from 
    the table used in Prim's algorithm. 
 */
public class PriorityQueueElement implements Comparable<PriorityQueueElement>{
		private int nodeId;
		private int priority;


		public PriorityQueueElement(int priority, int nodeId) {
			this.nodeId = nodeId;
			this.priority = priority;
		}

		public int getPriority() {
			return this.priority;
		}

		public int getNodeId() {
			return this.nodeId;
		}

		public void setPriority(int newPriority) {
			this.priority = newPriority;
		}

		//@Override
		int c;
		public int compareTo(PriorityQueueElement o) {
			// FILL IN CODE
			if (this.priority < o.getPriority()) {
				c = -1;
			} else if (this.priority > o.getPriority()) {
				c = 1;
			}
			
			return c;
		}
}
