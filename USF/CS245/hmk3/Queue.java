
/** An interface for the Queue ADT */
public interface Queue {
	public void enqueue(Object elem);

	public Object dequeue();

	public boolean empty();
}