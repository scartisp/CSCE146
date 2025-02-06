//simion cartis

public class LLQueue<T> implements QueueI<T> {
	private class ListNode {
		T data;
		ListNode link;

		public ListNode(T aData, ListNode aLink) {
			data = aData;
			link = aLink;
		}
	}

	private ListNode head;
	private ListNode tail;

	public LLQueue() {
		head = tail = null;
	}

	public void enqueue(T aData) {
		ListNode newNode = new ListNode(aData, null);
		if (head == null) {
			head = tail = newNode;
			return;
		}
		tail.link = newNode;// adds something to the END of the list 
		tail = tail.link; // (last in last out)
	}

	public T dequeue() {
		if (head == null)
			return null;//removes the first item from the list
		T ret = head.data; // (first in first out)
		head = head.link;
		return ret;
	}
	public T peek() {
		if(head == null)
			return null;
		return head.data;
	}
	public void print() {
		for (ListNode temp = head; temp != null; temp = temp.link)// uses a for loop to move through the list
			System.out.println(temp.data);//less code needed
	}
}
