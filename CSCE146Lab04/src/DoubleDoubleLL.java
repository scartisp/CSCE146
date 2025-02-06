//Simion Cartis
public class DoubleDoubleLL {
	private class ListNode {
		double data;
		ListNode forward;
		ListNode previous;

		public ListNode(double aData) {
			this.data = aData;
			this.forward = null;
			this.previous = null;
		}
	}

	private ListNode head;
	private ListNode current;
	private ListNode tail;// do not need a previous here as the link named "previous" does that job

	public DoubleDoubleLL() {
		head = null;
		current = null;
		tail = null;
	}

	public void gotoNext() {
		if (current != null)
			current = current.forward;
	}

	public void gotoPrev() {
		if (current != null)
			current = current.previous;// instead of defining a new ListNode for previous, simply create a
	}// link that points back and use that

	public void reset() {
		current = head;
	}

	public void gotoEnd() {
		current = tail;
	}

	public boolean hasMore() {
		return current != null;
	}

	public Double getCurrent() {
		if (current == null)
			return null;
		else
			return current.data;
	}

	public void setCurrent(double aData) {
		if (current == null)
			return;
		else
			current.data = aData;
	}

	public void add(double aData) {
		ListNode newNode = new ListNode(aData);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.forward = newNode;// this creates a new node after the tail
			newNode.previous = tail;// defines tail as before the new node
			tail = newNode;// and then redefines tail as the new node
		}
	}

	public void addAfterCurrent(double aData) {
		// ListNode newNode = new ListNode(aData);
		if (current != null) {
			ListNode newNode = new ListNode(aData);
			newNode.forward = current.forward;
			// newNode.previous = current;
			if (current.forward != null)
				current.forward.previous = newNode; // current.forward.previous is the previous link of the node that
													// current.forward points to. in other words, it points to the
													// .previous of the node after the node you are adding
			else
				tail = newNode;
			newNode.previous = current;
			current.forward = newNode;
		}
	}

	public void remove(double aData) {
		ListNode temp = head;
		while (temp != null) {
			if (temp.data == aData) {
				if (temp.previous != null) {
					temp.previous.forward = temp.forward;
				} else {
					head = temp.forward;
				}
				if (temp.forward != null) {
					temp.forward.previous = temp.previous;
				} else
					tail = temp.previous;
				return;
			}
			temp = temp.forward;
		}
	}

	public void removeCurrent() {
		if (current != null) {
			if (current.previous != null)
				current.previous.forward = current.forward;
			else
				head = current.forward;
			if (current.forward != null) {
				current.forward.previous = current.previous;
			} else
				tail = current.previous;
			current = current.forward; // this pushes a current node back and sets current to whatever is
		} // in front of it
	}

	public void print() {
		ListNode temp = head;
		while (temp != null) {
			System.out.println(temp.data + " ");
			temp = temp.forward;
		}
		System.out.println();
	}

	public boolean contains(double aData) {
		ListNode temp = head;
		while (temp != null) {
			if (temp.data == aData)
				return true;
			temp = temp.forward;
		}
		return false;
	}
}
