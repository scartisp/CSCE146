/*
 * simion Cartis
 */
public interface QueueI<T> {
	public void enqueue(T aData);
	public T dequeue();
	public T peek();
	public void print();
	public void clear(); // need to write the methods in the interface for the RobotQueueImplement class to
}// have them
