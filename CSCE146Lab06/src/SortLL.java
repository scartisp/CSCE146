//Simion Cartis

public class SortLL {
	private class ListNode {
		Sort data;
		ListNode link;

		public ListNode() {
			this.data = null;
			this.link = null;
		}

		public ListNode(Sort aData, ListNode aLink) {
			data = aData;
			link = aLink;
		}
	}

	private ListNode head;
	private ListNode current;
	private ListNode previous;
	private int size;

	public SortLL() {
		head = null;
		head = current;
		head = previous;
		size = 0;
	}

	public void add(Sort aData) {
		ListNode newNode = new ListNode(aData, null);
		if (head == null) {
			head = current = previous = newNode;
			size++;
			return;
		} else {
			ListNode temp = head;
			while (temp.link != null)
				temp = temp.link;
			temp.link = newNode;
		}
		size++;
	}

	public void print() {
		ListNode temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.link;
		}
	}

	public void gotoNext() {
		if (current == null)
			return;
		previous = current;
		current = current.link;
	}

	public Sort getCurrent() {
		if (current == null)
			return null;
		else
			return current.data;
	}

	public void reset() {
		current = head;
		previous = null;
	}

	public void clear() {
		head = null;
		current = null;
		previous = null;
		size = 0;
	}
	
	public int getSize() {
		return size;// need to get the size of the list so that I can specify how big the array needs to be
	}
	
}
