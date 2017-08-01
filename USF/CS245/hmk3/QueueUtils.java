/**
 * A class that contains a static method that returns the reverse of a given
 * queue.
 */
public class QueueUtils {
	/**
	 * A recursive function that reverses a given ArrayQueue and stores the
	 * result in a variable reversedQueue. You can use only Queue operations:
	 * enqueue(Object elem), dequeque() and empty().
	 * 
	 * @param originalQueue
	 * @param reversedQueue
	 */

	public static void reverse(ArrayQueue originalQueue, ArrayQueue reversedQueue) {
		//base case:
		if (originalQueue.empty()) {
			return;
		}

		Object current = originalQueue.dequeue(); //save as a temporary variable
		
		reverse(originalQueue, reversedQueue); //recursion

		reversedQueue.enqueue(current); //enqueue to the reversed queue
		
	}

}
