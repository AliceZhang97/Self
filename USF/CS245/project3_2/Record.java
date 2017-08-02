public class Record {
	private int key; 
	private Object data;

	public Record (int key, Object data) { 
		this.key = key;
		this.data = data;
	}
	public int key() { 
		return key;
	}
	public String toString() {
		return key + " " + data.toString();
	}
}