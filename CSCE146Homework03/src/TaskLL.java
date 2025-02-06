//Simion Cartis

public class TaskLL {
	private class ListNode {
		TaskItems data;
		ListNode link;

		public ListNode() {
			this.data = null;
			this.link = null;
		}

		public ListNode(TaskItems aData, ListNode aLink) {
			data = aData;
			link = aLink;
		}
	}

	private ListNode head;
	private ListNode current;
	private ListNode previous;
	private int size;

	public TaskLL() {
		head = null;
		head = current;
		head = previous;
		size = 0;
	}

	public void add(TaskItems aData) {
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

	public boolean hasNext() {
		return current != null;
	}

	public TaskItems getCurrent() {
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
	public void removeCurrent() {
		if (current == head) {
			head = head.link;
			current = head;
		} else {
			previous.link = current.link;
			current = current.link;
		}
		size--;
	}

	public boolean contains(TaskItems aData) {
		if(current.data.equals(aData))
			return true;
		else
			return false; // the contains method needs to check if the current item has the same data
	}// not just if the whole list has the data
	
	public boolean containsInList(TaskItems aData) {// need to write an additional contains method
		ListNode temp = head;// to check if the item is in the list in general 
		while (temp != null) {
			if (temp.data.equals(aData))
				return true;
			temp = temp.link;
		}
		return false;
	}

	
	public int getSize() {
		return size;
	}
}
