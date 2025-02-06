//Simion Cartis

public class GamesList {
	private class ListNode {
		GameItems data;
		ListNode link;

		public ListNode() {
			this.data = null;
			this.link = null;
		}

		public ListNode(GameItems aData, ListNode aLink) {
			data = aData;
			link = aLink;
		}
	}

	private ListNode head;
	private ListNode current;
	private ListNode previous;
	private int size;
	// private int size;

	public GamesList() {
		head = null;
		head = current;
		head = previous;
		size = 0;
	}

	public void add(GameItems aData) {
		ListNode newNode = new ListNode(aData, null);// this basically creates a new
		if (head == null) { // spot in the linked list, moves that spot until it finds an empty space
			head = current = previous = newNode; // and then inserts new data
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

	public GameItems getCurrent() {
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

	public int getSize() { //this getSize method is useful as 
		return size; //you are checking the size of two different lists meaning you'd have to make two
	}//unique objects for that, or you can just make a single method and use .getSize()
}
